Ext.define('Projectone.projectone.shared.projectone.model.authentication.UserAccessLevelModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userAccessLevelId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userAccessLevel",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "levelName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelHelp",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});