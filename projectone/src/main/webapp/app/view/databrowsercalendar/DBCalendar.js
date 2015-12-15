Ext.define('Projectone.view.databrowsercalendar.DBCalendar', {
	extend : 'Projectone.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Projectone.view.databrowsercalendar.DBCalendarController',
	             'Projectone.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
