Ext.define('Projectone.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Projectone.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Projectone.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
