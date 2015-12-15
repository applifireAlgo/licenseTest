Ext.define('Projectone.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Projectone.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Projectone.view.mobileview.reportui.datachart.DataChartViewTab',
			'Projectone.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Projectone.view.mobileview.reportui.ReportViewController' ,
			'Projectone.view.mobileview.fw.DataPointPanel',
			'Projectone.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
