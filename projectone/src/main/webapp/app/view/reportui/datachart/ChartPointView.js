Ext.define('Projectone.view.reportui.datachart.ChartPointView', {
	extend : 'Ext.panel.Panel',
	requires:['Projectone.view.reportui.datachart.ChartPointController'],
	xtype : 'chart-point',
	controller : 'chartPointController',
	//bodyStyle : 'background:#D8D8D8',
	itemId:"chartpoint",
	
	defualtHeight:100,
	layout : {
		type : 'hbox',
	}
});

