Ext.define('Projectone.view.querybuildernewmodel.querycondition.QueryFromTree', {
	extend : 'Ext.tree.TreePanel',
	requires:['Projectone.view.querybuildernewmodel.querycondition.QueryFromController',
	          'Projectone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore','Ext.selection.CheckboxModel'],
	controller:'query-from',
	xtype : 'query-from',
	useArrows:true,
	rootVisible: false,
	loadMask :true,
	folderSort :true,
	checked:false,
    title: '',
    /*	selModel :Ext.create('Ext.selection.CheckboxModel',{
	    	mode: 'SIMPLE',
	        checkOnly: true,
	    	listeners:{}
	    }),*/
});
