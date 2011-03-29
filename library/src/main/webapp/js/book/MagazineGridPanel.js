Ext.ns('Library.magazine.grid');

Library.magazine.grid.MagazineGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'magazineGridPanel',
	
	initComponent : function(){
		
		// ����ͼ���б�Ĺ�����
		var tbar = new Ext.Toolbar({
			items : [{
				text : '��ѯ',
				handler : function() {
					
				}
			}, {
				text : '�޸�',
				handler : function() {
					
				}
			}, {
				text : '����',
				handler : function() {
					
				}
			}, {
				text : 'ɾ��',
				handler : function() {
					this.deleteMagazine();
				},
				scope:this
			},  {
				text : '����',
				handler : function() {
					
				}
			},  {
				text : '����Excel',
				handler : function() {
					
				}
			},  {
				text : 'ͼ���ǩ',
				handler : function() {
					
				}
			},  {
				text : '��ӡ������',
				handler : function() {
					
				}
			}]
		});
		
		var fields = [{
			name : 'magazineId',
			type : 'int'
		}, {
			name : 'barCode',
			type : 'string'
		}, {
			name : 'magazineName',
			type : 'string'
		}, {
			name : 'magazineDesc',
			type : 'string'
		}, {
			name : 'donator',
			type : 'string'
		}, {
			name : 'author',
			type : 'string'
		}, {
			name : 'translator',
			type : 'string'
		}, {
			name : 'ISBN',
			type : 'string'
		}, {
			name : 'ISSN',
			type : 'string'
		}, {
			name : 'emailNo',
			type : 'string'
		}, {
			name : 'stage',
			type : 'string'
		}, {
			name : 'allStage',
			type : 'string'
		}, {
			name : 'pages',
			type : 'int'
		}, {
			name : 'price',
			type : 'float'
		}, {
			name : 'publisherDate',
			type : 'string'
		}, {
			name : 'quantity',
			type : 'int'
		}, {
			name : 'location',
			type : 'string'
		}, {
			name : 'revision',
			type : 'int'
		}, {
			name : 'searchMagazineId',
			type : 'string'
		}, {
			name : 'speciesId',
			type : 'string'
		}, {
			name : 'spell',
			type : 'string'
		}, {
			name : 'storeDate',
			type : 'string'
		}, {
			name : 'MagazineNo',
			type : 'string'
		}, {
			name : 'isMagazine',
			type : 'boolean'
		}, {
			name : 'firstCategoryId',
			type : 'string'
		}, {
			name : 'firstCategoryName',
			type : 'string'
		}, {
			name : 'secondCategoryId',
			type : 'string'
		}, {
			name : 'secondCategoryName',
			type : 'string'
		}, {
			name : 'hasAttachment',
			type : 'string'
		}, {
			name : 'magazineStateId',
			type : 'string'
		}, {
			name : 'magazineStateName',
			type : 'string'
		}, {
			name : 'magazineLevelId',
			type : 'string'
		}, {
			name : 'magazineLevelName',
			type : 'string'
		}, {
			name : 'securityId',
			type : 'string'
		}, {
			name : 'securityName',
			type : 'string'
		}, {
			name : 'currencyId',
			type : 'string'
		}, {
			name : 'pressId',
			type : 'string'
		}, {
			name : 'pressName',
			type : 'string'
		}, {
			name : 'resourceId',
			type : 'string'
		}, {
			name : 'resourceName',
			type : 'string'
		}];
		
		var selectModel = new Ext.grid.CheckboxSelectionModel();
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/books/findMagazines.action',
			totalProperty : 'totalProperty',
			root : 'root',
			storeInfo : {
				field : '����',
				direction : 'ASC|DESC'
			},
			fields : fields
		});
		
		
		
		var colM = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
		        selectModel,
		   {
				header : '���',
				dataIndex : 'magazineNo',
				sortable : true,
				width : 80,
				align : 'center'
			}, {
				header : '����',
				dataIndex : 'magazineName',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '�����',
				dataIndex : 'firstCategoryName',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '����',
				dataIndex : 'author',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '�ִκ�',
				dataIndex : 'speciesName',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '����',
				dataIndex : 'quantity',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '���ʱ��',
				dataIndex : 'storeDate',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : 'ҳ��',
				dataIndex : 'pages',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '����',
				dataIndex : 'hasAttachment',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '״̬',
				dataIndex : 'magazineStateName',
				width : 80,
				sortable : true,
				align : 'center'
			}
		]);
		
		Ext.apply(this, {
			width : 1000,
//			height : document.documentElement.clientHeight * 0.82,
			height : 500,
			autoScroll : true,
			tbar : tbar,
			cm : colM,
			selModel: selectModel,
			store : store,
			stripeRows : true,
			columnLines : true,
			frame : false,
			bbar : new Ext.Toolbar([new Ext.PagingToolbar({
					store : store,
					pageSize : MagazinesPageSize,
					afterPageText : '/ {0}',
					beforePageText : 'ҳ',
					displayInfo : true,
					firstText : '��һҳ',
					prevText : 'ǰһҳ',
					nextText : '��һҳ',
					lastText : '���һҳ',
					refreshText : 'ˢ��',
					displayMsg : '��ʾ�� {0}-{1}�� ��{2}�� ',
					emptyMsg : 'û������'
				})
			])
//			view : new Ext.ux.grid.BufferView({
//				rowHeight : 23,
//				scrollDelay : false,
//				columnsText : '��ʾ����',
//				scrollOffset : 30,
//				sortAscText : '����',
//				sortDescText : '����'
//			})
		});
		
		Library.magazine.grid.MagazineGridPanel.superclass.initComponent.call(this);
		
		//�����¼�����
		this.addListener('rowdblclick', function(){
			
		}, this);
		
		this.addListener('rowclick', function(){
			
		}, this);
		
	},
	
	addMagazine : function() {
		
	},
	
	updateMagazine : function(){
	  
	},
	
    deleteMagazine : function() {
		var sm = this.getSelectionModel();
		alert(sm);
		var thiz = this;
		if(sm.hasSelection()){
			var record = sm.getSelected();
			var magazineId = record.get('magazineId');
			alert(magazineId);
			Ext.Ajax.request({
				url : contextPath + '/books/deleteMagazine.action',
				method : 'POST',
				params : {
					bookId : magazineId
				},
				success : function(resp){
					alert('�ɹ��ӷ���������');
					var respText = resp.responseText;
					var obj = Ext.util.JSON.decode(respText);
				    alert(obj);
				},
				failure : function(){
					alert('�������쳣');
				}
			});
		}
	}	
});
