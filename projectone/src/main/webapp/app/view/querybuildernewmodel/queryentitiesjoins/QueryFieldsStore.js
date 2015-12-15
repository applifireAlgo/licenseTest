Ext.define('Projectone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Projectone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Projectone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
