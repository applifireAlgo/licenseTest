Ext
		.define(
				'Projectone.view.mobileview.reportui.datachart.datagrid.DataGridView',
				{
					extend : 'Ext.grid.Panel',
					requires : [ 'Projectone.view.mobileview.reportui.datachart.datagrid.DataGridController' ],
					xtype : 'data-grid-view',
					controller:'datagridController',
					autoscroll:true,
					itemId : 'data-grid-view',
					width : "100%",
					listeners : {
						scope:'controller',
						cellclick : 'dataGridCellClick',
						itemcontextmenu : 'dataGridRightClick',
					}
				// store:'',

				});
