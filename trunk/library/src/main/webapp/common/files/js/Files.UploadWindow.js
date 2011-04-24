Ext.ns('Files');

var jsonData = [];

Files.UploadWindow = Ext.extend(Ext.Window, {
	//文件列表
	fileList : null,
	//核心上传对象
	swfupload : null,
	//进度条
	progressBar : null,
	//进度信息
	progressInfo : null,
	//上传信息面板
	uploadInfoPanel : null,
	
	constructor : function(config) {
		//进度信息对象
		this.progressInfo = {
			filesTotal : 0,
			filesUploaded : 0,
			bytesTotal : 0,
			bytesUploaded : 0,
			currentCompleteBytes : 0,
			lastBytes : 0,
			lastElapsed : 1,
			lastUpdate : null,
			timeElapsed : 1
		};
		//上传信息面板
		this.uploadInfoPanel = new Ext.Panel({
			region : 'north',
			height : 65,
			baseCls : '',
			collapseMode : 'mini',
			split : true,
			border : false
		});
		//进度条对象
		this.progressBar = new Ext.ProgressBar({
			text : '等待中 0 %',
			animate : true
		});
		//自动展开的列标识
		var autoExpandColumnId = Ext.id('fileName');
		//更新上传信息面板
		this.uploadInfoPanel.on('render', function() {
			this.getProgressTemplate().overwrite(this.uploadInfoPanel.body, {
				filesUploaded : 0,
				filesTotal : 0,
				bytesUploaded : '0 bytes',
				bytesTotal : '0 bytes',
				timeElapsed : '00:00:00',
				timeLeft : '00:00:00',
				speedLast : '0 bytes/s',
				speedAverage : '0 bytes/s'
			});
		}, this);
		
		//文件列表面板
		this.fileList = new Ext.grid.GridPanel({
			border : false,
			enableColumnMove : false,
			enableHdMenu : false,
			columns : [new Ext.grid.RowNumberer(), {
				header : '文件名',
				width : 100,
				dataIndex : 'fileName',
				sortable : false,
				fixed : true,
				renderer : this.formatFileName,
				id : autoExpandColumnId
			}, {
				header : '大小',
				width : 80,
				dataIndex : 'fileSize',
				sortable : false,
				fixed : true,
				renderer : this.formatFileSize,
				align : 'right'
			}, {
				header : '类型',
				width : 60,
				dataIndex : 'fileType',
				sortable : false,
				fixed : true,
				renderer : this.formatIcon,
				align : 'center'
			}, {
				header : '进度',
				width : 100,
				dataIndex : '',
				sortable : false,
				fixed : true,
				renderer : this.formatProgressBar,
				align : 'center'
			}, {
				header : '&nbsp;',
				width : 28,
				dataIndex : 'fileState',
				renderer : this.formatState,
				sortable : false,
				fixed : true,
				align : 'center'
			}],
			autoExpandColumn : autoExpandColumnId,
			ds : new Ext.data.SimpleStore({
				fields : ['fileId', 'fileName', 'fileSize', 'fileType', 'fileState']
			}),
//			bbar : [this.progressBar],
			tbar : [{
				//此处理的实际功能应该由影片剪辑来完成
				text : '添加文件',
				iconCls : 'db-icn-add'
			}, {
				text : '开始上传',
				iconCls : 'db-icn-upload_',
				handler : this.startUpload,
				scope : this
			}, {
				text : '停止上传',
				iconCls : 'db-icn-stop',
				handler : this.stopUpload,
				scope : this
			}, {
				text : '取消队列',
				iconCls : 'db-icn-cross',
				handler : this.cancelQueue,
				scope : this
			}, {
				text : '清空列表',
				iconCls : 'db-icn-trash',
				handler : this.clearList,
				scope : this
			}],
			errorTip : new Ext.Tip({html:'测试'}),
			listeners : {
				cellclick : {
					fn : function(grid, rowIndex, columnIndex, e) {
						if (columnIndex == 5) {
							var record = grid.getSelectionModel().getSelected();
							var fileId = record.data.fileId;
							var file = this.swfupload.getFile(fileId);
							if (file) {
								if (file.filestatus != SWFUpload.FILE_STATUS.CANCELLED) {
									this.swfupload.cancelUpload(fileId);
									if (record.data.fileState != SWFUpload.FILE_STATUS.CANCELLED) {
										record.set('fileState', SWFUpload.FILE_STATUS.CANCELLED);
										record.commit();
										this.onCancelQueue(fileId);
									}
								}
							}
						}
					},
					scope : this
				},
				render : {
					fn : function() {
						//获取网格面板
						var grid = this.get(1).get(0);
						//获取添加按钮
						var em = grid.getTopToolbar().get(0).el.child('em');
						var placeHolderId = Ext.id();
						em.setStyle({
							position : 'relative',
							display : 'block'
						});
						//创建影片剪辑的容器
						em.createChild({
							tag : 'div',
							id : placeHolderId
						});
						//影片剪辑的设置
						var settings = {
							upload_url : this.uploadUrl,
							//其它需要上传的参数
							post_params : Ext.isEmpty(this.postParams) ? {} : this.postParams,
							flash_url : contextPath + '/common/files/swfu/v25/core/swfupload_fp10/swfupload.swf',
							flash9_url : contextPath + '/common/files/swfu/v25/core/swfupload_fp9/swfupload_fp9.swf',
							//上传时的文件字段名
							file_post_name : Ext.isEmpty(this.filePostName) ? 'upload' : this.filePostName,
							//文件大小限制
							file_size_limit : Ext.isEmpty(this.fileSize) ? '100 MB' : this.fileSize,
							//文件类型限制
							file_types : Ext.isEmpty(this.fileTypes) ? '*.*' : this.fileTypes,
							//文件类型描述
							file_types_description : this.fileTypesDescription,
							//设置其它参数上传方式GET
							use_query_string : true,
							//是否打开调试
							debug : false,
							button_width : '73',
							button_height : '20',
							button_placeholder_id : placeHolderId,
							//影片剪辑的模式为透明
							button_window_mode : SWFUpload.WINDOW_MODE.TRANSPARENT,
							button_cursor : SWFUpload.CURSOR.HAND,
							custom_settings : {
								scope_handler : this
							},
							//文件添加成功的处理器
							file_queued_handler : this.onFileQueued,
							//文件添加错误的处理器
							file_queue_error_handler : this.onFileQueueError,
							//文件添加对象框架关闭的处理器
							file_dialog_complete_handler : this.onFileDialogComplete,
							//开始上传的处理器
							upload_start_handler : this.onUploadStart,
							//进度更新处理处理器
							upload_progress_handler : this.onUploadProgress,
							//上传错误处理器
							upload_error_handler : this.onUploadError,
							//上传成功处理器
							upload_success_handler : this.onUploadSuccess,
							//上传完成的处理器
							upload_complete_handler : this.onUploadComplete
						};
						//构建影片剪辑对象
						this.swfupload = new SWFUpload(settings);
						//上传对象没有这个属性???
						this.swfupload.uploadStopped = false;
						//设置影片剪辑与添加按钮的相对位置
						Ext.get(this.swfupload.movieName).setStyle({
							position : 'absolute',
							top : 0,
							left : -2
						});
						//设置进度条大小
						this.resizeProgressBar();
						//监听进度条大小改变
						this.on('resize', this.resizeProgressBar, this);
					},
					scope : this,
					delay : 100
				}
			}

		});
		this.fileList.on('beforedestroy', function(){
			this.onBeforeClose();
		}, this);
		Files.UploadWindow.superclass.constructor.call(this, Ext.applyIf(config || {},{
			title : '文件上传',
			closeAction : 'close',
			layout : 'border',
			iconCls : 'db-icn-upload-local',
			//modal : true,
			width : 500,
			height : 500,
			minWidth : 450,
			minHeight : 400,
			buttons : [{text : '关闭',handler : this.onClose,scope : this}],
			items : [this.uploadInfoPanel,{
				region : 'center',
				layout:'fit',
				margins : '0 -1 0 -1',
				items : [this.fileList]
			}]}
		));
	},
	resizeProgressBar : function() {
		this.progressBar.setWidth(this.el.getWidth() - 5);
	},
	
	//监听开始上传
	startUpload : function() {
		if (this.swfupload) {
			//表示上传中...
			this.swfupload.uploadStopped = false;
			var post_params = this.swfupload.settings.post_params;
			// console.log(post_params);
			// post_params.path = encodeURI(this.scope.currentPath + '\\');
			// this.swfupload.setPostParams(post_params);
			this.swfupload.startUpload();
		}
	},
	//停止上传
	stopUpload : function() {
		if (this.swfupload) {
			//表示已经停止
			this.swfupload.uploadStopped = true;
			this.swfupload.stopUpload();
		}
	},
	//取消队列
	cancelQueue : function() {
		if (this.swfupload) {
			//先停止上传
			this.swfupload.stopUpload();
			//获取全局统计
			var stats = this.swfupload.getStats();
			while (stats.files_queued > 0) {
				//循环取消所有上传队列
				this.swfupload.cancelUpload();
				stats = this.swfupload.getStats();
			}
			
			this.fileList.getStore().each(function(record) {
				switch (record.data.fileState) {
					case SWFUpload.FILE_STATUS.QUEUED :
					case SWFUpload.FILE_STATUS.IN_PROGRESS :
						record.set('fileState', SWFUpload.FILE_STATUS.CANCELLED);
						record.commit();
						//取消指标的记录
						this.onCancelQueue(record.data.fileId);
						break;
					default :
						break;
				}
			}, this);
		}
	},
	clearList : function() {
		jsonData = [];
		this.cancelQueue();
		var store = this.fileList.getStore();
		store.each(function(record) {
			//删除那些还没有上传的文件
			if (record.data.fileState != SWFUpload.FILE_STATUS.QUEUED
					&& record.data.fileState != SWFUpload.FILE_STATUS.IN_PROGRESS) {
				store.remove(record);
			}
		});
	},
	
	//这个地方有明显的失误,这个地方应该缓存模板对象
	getProgressTemplate : function() {
		if(!Files.UploadWindow.tpl){
			var tpl = new Ext.Template('<table class="upload-progress-table"><tbody>',
					'<tr><td class="upload-progress-label"><nobr>已上传数:</nobr></td>',
					'<td class="upload-progress-value"><nobr>{filesUploaded} / {filesTotal}</nobr></td>',
					'<td class="upload-progress-label"><nobr>上传状态:</nobr></td>',
					'<td class="upload-progress-value"><nobr>{bytesUploaded} / {bytesTotal}</nobr></td></tr>',
					'<tr><td class="upload-progress-label"><nobr>已用时间:</nobr></td>',
					'<td class="upload-progress-value"><nobr>{timeElapsed}</nobr></td>',
					'<td class="upload-progress-label"><nobr>剩余时间:</nobr></td>',
					'<td class="upload-progress-value"><nobr>{timeLeft}</nobr></td></tr>',
					'<tr><td class="upload-progress-label"><nobr>当前速度:</nobr></td>',
					'<td class="upload-progress-value"><nobr>{speedLast}</nobr></td>',
					'<td class="upload-progress-label"><nobr>平均速度:</nobr></td>',
					'<td class="upload-progress-value"><nobr>{speedAverage}</nobr></td></tr>', '</tbody></table>');
			Files.UploadWindow.tpl = tpl.compile();
		}
		return Files.UploadWindow.tpl;
	},
	//更新进度信息
	updateProgressInfo : function() {
		this.getProgressTemplate().overwrite(this.uploadInfoPanel.body, this.formatProgress(this.progressInfo));
	},
	
	formatProgress : function(info) {
		var r = {};
		r.filesUploaded = String.leftPad(info.filesUploaded, 3, '&nbsp;');
		r.filesTotal = info.filesTotal;
		r.bytesUploaded = String.leftPad(Ext.util.Format.fileSize(info.bytesUploaded), 6, '&#160;');
		r.bytesTotal = Ext.util.Format.fileSize(info.bytesTotal);
		r.timeElapsed = this.formatTime(info.timeElapsed);
		r.speedAverage = Ext.util.Format.fileSize(Math.ceil(1000 * info.bytesUploaded / info.timeElapsed)) + '/s';
		r.timeLeft = this.formatTime((info.bytesUploaded === 0) ? 0 : info.timeElapsed
				* (info.bytesTotal - info.bytesUploaded) / info.bytesUploaded);
		var caleSpeed = 1000 * info.lastBytes / info.lastElapsed;
		r.speedLast = Ext.util.Format.fileSize(caleSpeed < 0 ? 0 : caleSpeed) + '/s';
		var p = info.bytesUploaded / info.bytesTotal;
		p = p || 0;
		this.progressBar.updateProgress(p, "上传中 " + Math.ceil(p * 100) + " %");
		return r;
	},
	formatTime : function(milliseconds) {
		var seconds = parseInt(milliseconds / 1000, 10);
		var s = 0;
		var m = 0;
		var h = 0;
		if (3599 < seconds) {
			h = parseInt(seconds / 3600, 10);
			seconds -= h * 3600;
		}
		if (59 < seconds) {
			m = parseInt(seconds / 60, 10);
			seconds -= m * 60;
		}
		m = String.leftPad(m, 2, '0');
		h = String.leftPad(h, 2, '0');
		s = String.leftPad(seconds, 2, '0');
		return h + ':' + m + ':' + s;
	},
	formatFileSize : function(_v, celmeta, record) {
		return '<div id="fileSize_' + record.data.fileId + '">' + Ext.util.Format.fileSize(_v) + '</div>';
	},
	formatFileName : function(_v, cellmeta, record) {
		return '<div id="fileName_' + record.data.fileId + '">' + _v + '</div>';
	},
	formatIcon : function(_v, cellmeta, record) {
		var returnValue = '';
		var extensionName = _v.substring(1);
		var fileId = record.data.fileId;
		if (_v) {
			var css = '.db-ft-' + extensionName.toLowerCase() + '-small';
			if (Ext.isEmpty(Ext.util.CSS.getRule(css), true)) { // 判断样式是否存在
				returnValue = '<div id="fileType_' + fileId
						+ '" class="db-ft-unknown-small" style="height: 16px;background-repeat: no-repeat;">'
						+ '&nbsp;&nbsp;&nbsp;&nbsp;' + extensionName.toUpperCase() + '</div>';
			} else {
				returnValue = '<div id="fileType_' + fileId + '" class="db-ft-' + extensionName.toLowerCase()
						+ '-small" style="height: 16px;background-repeat: no-repeat;"/>&nbsp;&nbsp;&nbsp;&nbsp;'
						+ extensionName.toUpperCase();
				+'</div>';
			}
			return returnValue;
		}
		return '<div id="fileType_'
				+ fileId
				+ '" class="db-ft-unknown-small" style="height: 16px;background-repeat: no-repeat;"/>&nbsp;&nbsp;&nbsp;&nbsp;'
				+ extensionName.toUpperCase() + '</div>';
	},
	formatProgressBar : function(_v, cellmeta, record) {
		var returnValue = '';
		switch (record.data.fileState) {
			case SWFUpload.FILE_STATUS.COMPLETE :
				if (Ext.isIE) {
					returnValue = '<div class="x-progress-wrap" style="height: 18px">'
							+ '<div class="x-progress-inner">'
							+ '<div style="width: 100%;" class="x-progress-bar x-progress-text">' + '100 %'
					'</div>' + '</div>' + '</div>';
				} else {
					returnValue = '<div class="x-progress-wrap" style="height: 18px">'
							+ '<div class="x-progress-inner">' + '<div id="progressBar_' + record.data.fileId
							+ '" style="width: 100%;" class="x-progress-bar">' + '</div>' + '<div id="progressText_'
							+ record.data.fileId
							+ '" style="width: 100%;" class="x-progress-text x-progress-text-back" />100 %</div>'
					'</div>' + '</div>';
				}
				break;
			default :
				returnValue = '<div class="x-progress-wrap" style="height: 18px">' + '<div class="x-progress-inner">'
						+ '<div id="progressBar_' + record.data.fileId + '" style="width: 0%;" class="x-progress-bar">'
						+ '</div>' + '<div id="progressText_' + record.data.fileId
						+ '" style="width: 100%;" class="x-progress-text x-progress-text-back" />0 %</div>'
				'</div>' + '</div>';
				break;
		}
		return returnValue;
	},
	formatState : function(_v, cellmeta, record) {
		var returnValue = '';
		switch (_v) {
			case SWFUpload.FILE_STATUS.QUEUED :
				returnValue = '<span id="' + record.id + '"><div id="fileId_' + record.data.fileId
						+ '" class="ux-cell-icon-upload" qtip="'+record.get('serverData')+'"/></span>';
				break;
			case SWFUpload.FILE_STATUS.ERROR :
				returnValue = '<span id="' + record.id + '"><div id="fileId_' + record.data.fileId
						+ '" class="ux-cell-icon-delete" qtip="'+record.get('serverData')+'"/></span>';
				break;
			case SWFUpload.FILE_STATUS.CANCELLED :
				returnValue = '<span id="' + record.id + '"><div id="fileId_' + record.data.fileId
						+ '" class="ux-cell-icon-clear" qtip="'+record.get('serverData')+'"/></span>';
				break;
			case SWFUpload.FILE_STATUS.COMPLETE :
				if(record.get('serverData')=='上传成功'){
					returnValue = '<span id="' + record.id + '"><div id="fileId_' + record.data.fileId
							+ '" class="ux-cell-icon-completed" qtip="'+record.get('serverData')+'"/></span>';
				} else {
					returnValue = '<span id="' + record.id + '"><div id="fileId_' + record.data.fileId
						+ '" class="ux-cell-icon-delete" qtip="'+record.get('serverData')+'"/></span>';
				}
				break;
			default :
				alert('没有设置图表状态');
				break;
		}
		return returnValue;
	},
	onBeforeClose: function(){
		jsonData = [];
		fileList = null;
		swfupload = null;
		progressBar = null;
		progressInfo = null;
		uploadInfoPanel = null;
	},
	onClose : function() {
		this.close();
	},
	onCancelQueue : function(fileId) {
		Ext.getDom('fileName_' + fileId).className = 'ux-cell-color-gray';// 设置文字颜色为灰色
		Ext.getDom('fileSize_' + fileId).className = 'ux-cell-color-gray';
		Ext.DomHelper.applyStyles('fileType_' + fileId, 'font-style:italic;text-decoration: line-through;color:gray');
	},
	//当文件添加到网格中后回调
	onFileQueued : function(file) {
		var thiz = this.customSettings.scope_handler;
		thiz.fileList.getStore().add(new Files.UploadWindow.FileRecord({
			fileId : file.id,
			fileName : file.name,
			fileSize : file.size,
			fileType : file.type,
			fileState : file.filestatus,
			serverData : ''
		}));
		thiz.progressInfo.filesTotal += 1;
		thiz.progressInfo.bytesTotal += file.size;
		thiz.updateProgressInfo();
	},
	onQueueError : function(file, errorCode, message) {
		var thiz = this.customSettings.scope_handler;
		try {
			if (errorCode != SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED) {
				thiz.progressInfo.filesTotal -= 1;
				thiz.progressInfo.bytesTotal -= file.size;
			}
			thiz.progressInfo.bytesUploaded -= fpg.getBytesCompleted();
			thiz.updateProgressInfo();
		} catch (ex) {
			this.debug(ex);
		}
	},
	onFileDialogComplete : function(selectedFilesCount, queuedFilesCount) {
		// alert("selectedFilesCount:" + selectedFilesCount + "
		// queuedFilesCount:" + queuedFilesCount );
	},
	onUploadStart : function(file) {
	},
	onUploadProgress : function(file, completeBytes, bytesTotal) {
		var percent = Math.ceil((completeBytes / bytesTotal) * 100);
		Ext.getDom('progressBar_' + file.id).style.width = percent + "%";
		Ext.getDom('progressText_' + file.id).innerHTML = percent + " %";

		var thiz = this.customSettings.scope_handler;
		var bytes_added = completeBytes - thiz.progressInfo.currentCompleteBytes;
		thiz.progressInfo.bytesUploaded += Math.abs(bytes_added < 0 ? 0 : bytes_added);
		thiz.progressInfo.currentCompleteBytes = completeBytes;
		if (thiz.progressInfo.lastUpdate) {
			thiz.progressInfo.lastElapsed = thiz.progressInfo.lastUpdate.getElapsed();
			thiz.progressInfo.timeElapsed += thiz.progressInfo.lastElapsed;
		}
		thiz.progressInfo.lastBytes = bytes_added;
		thiz.progressInfo.lastUpdate = new Date();
		thiz.updateProgressInfo();
	},
	onUploadError : function(file, errorCode, message) {
		var thiz = this.customSettings.scope_handler;
		switch (errorCode) {
			case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED :
				thiz.progressInfo.filesTotal -= 1;
				thiz.progressInfo.bytesTotal -= file.size;
				thiz.updateProgressInfo();
				break;
			case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED :
		}
	},
	onUploadSuccess : function(file, serverData) {
		var thiz = this.customSettings.scope_handler;
		var serverData = Ext.util.JSON.decode(serverData);
		var record = thiz.fileList.getStore().getById(Ext.getDom('fileId_' + file.id).parentNode.id);
		if (serverData.success) {
			if(!jsonData)jsonData = [];
			jsonData.push(serverData['data']);
			record.set('fileState', file.filestatus);
			record.set('serverData', '上传成功')
			record.commit();
		} else {
			record.set('fileState', file.filestatus);
			record.set('serverData', serverData['error']||'上传失败');
			record.commit();
		}
		thiz.progressInfo.filesUploaded += 1;
		thiz.updateProgressInfo();
	},
	onUploadComplete : function(file) {
		//如果还存在没有上传的文件,且已经停止上传,则下始下一个文件的上传
		if (this.getStats().files_queued > 0 && this.uploadStopped == false) {
			this.startUpload();
		} else {//所有文件上传完成
			var thiz = this.customSettings.scope_handler;
			thiz.fireEvent('allfileuploaded', thiz, file, jsonData);//这里的
			var allfileoid = [];
			for(var i=0; i<jsonData.length; i++){
				var data = jsonData[i];
				allfileoid.push(data.oid);
			}
			thiz.fireEvent('allfileoid', allfileoid);//allfileoid：所有附件的id
			jsonData = [];
		}
	}
});

Files.UploadWindow.FileRecord = Ext.data.Record.create([{
	name : 'fileId'
}, {
	name : 'fileName'
}, {
	name : 'fileSize'
}, {
	name : 'fileType'
}, {
	name : 'fileState'
}, {
	name : 'serverData'
}]);

Ext.reg('filesuploadwindow', Files.UploadWindow);