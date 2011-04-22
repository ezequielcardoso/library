Ext.ns('Library.Util');

Library.Util = function() {
	return {
		applyIf : function(dest, source) {
			for (var p in source) {
				if (typeof dest[p] == "undefined") {// 测试在表单配置是否有此成员
					dest[p] = source[p];// 没有则添加
				} else if (typeof dest[p] == "object" && dest.hasOwnProperty(p)) {// 有则测试其是不是一个对象
					this.applyIf(dest[p], source[p]);
				}
			}
		},
		list : function(o, all) {
			var v = "";
			for (var p in o) {
				if(o.hasOwnProperty(p)){
					v += "属性:" + p + "值:" + o[p]+"\n";
				}
			}
			return v;
		},
		cfg : function(subConfig, baseConfig) {
			if (!subConfig || !baseConfig) {
				alert("在配置属性进行复制的时候,目标与源都不能为空");
			}
			if (!subConfig.init) {
				Risen.Util.applyIf(subConfig, baseConfig);
				subConfig.init = true;
			}
			return subConfig;
		},
		msg : function(msg, cfg) {
			cfg = cfg || {};
			cfg = Ext.isFunction(cfg) ? {cb : cfg} : cfg;
			var base = {
				title : '消息',
				msg : "<br />" + msg,
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO,
				width : 300,
				fn : cfg.cb || Ext.emptyFn
			};
			Ext.applyIf(cfg, base);
			Ext.MessageBox.show(cfg);
		},
		warn : function(msg, cfg) {
			cfg = cfg || {};
			cfg = Ext.isFunction(cfg) ? {cb : cfg} : cfg;
			var base = {
				title : '警告',
				msg : "<br />" + msg,
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.WARNING,
				width : 300,
				fn : cfg.cb || Ext.emptyFn
			};
			Ext.applyIf(cfg, base);
			Ext.MessageBox.show(cfg);
		},
		error : function(msg, cfg) {
			cfg = cfg || {};
			cfg = Ext.isFunction(cfg) ? {cb : cfg} : cfg;
			var base = {
				title : '错误',
				msg : "<br />" + msg,
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR,
				width : 300,
				fn : cfg.cb || Ext.emptyFn
			};
			Ext.applyIf(cfg, base);
			Ext.MessageBox.show(cfg);
		},
		confirm : function(msg, cfg) {
			cfg = cfg || {};
			cfg = Ext.isFunction(cfg) ? {cb : cfg} : cfg;
			var base = {
                title : "确认",
                msg : msg,
                width : 300,
                buttons: Ext.Msg.YESNO,
                fn: cfg.cb || Ext.emptyFn,
                icon: Ext.Msg.QUESTION
			};
			Ext.applyIf(cfg, base);
			Ext.MessageBox.show(cfg);
		},
		prompt : function(msg, cfg){
			cfg = cfg || {};
			cfg = Ext.isFunction(cfg) ? {cb : cfg} : cfg;
			var base = {
                title : '输入框',
                msg : msg,
                buttons: Ext.Msg.OKCANCEL,
                minWidth:300,
                fn : cfg.cb || Ext.emptyFn,
                prompt:true
            };
            Ext.applyIf(cfg, base);
			Ext.MessageBox.show(cfg);
		}
	}
}();