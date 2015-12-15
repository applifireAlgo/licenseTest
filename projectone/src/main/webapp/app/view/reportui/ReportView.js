Ext.define('Projectone.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Projectone.view.reportui.querycriteria.QueryCriteriaView',
			'Projectone.view.reportui.datachart.DataChartViewTab',
			'Projectone.view.reportui.datachart.DataChartViewPanel',
			'Projectone.view.reportui.ReportViewController' ,
			'Projectone.view.fw.MainDataPointPanel',
			'Projectone.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
