Ext.define('Projectone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Projectone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Projectone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
