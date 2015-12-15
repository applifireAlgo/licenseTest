Ext.define('Projectone.projectone.web.projectone.view.location.TalukaMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TalukaMainController",
     "restURL": "/Taluka",
     "defaults": {
          "split": true
     },
     "requires": ["Projectone.projectone.shared.projectone.model.location.TalukaModel", "Projectone.projectone.web.projectone.controller.location.TalukaMainController", "Projectone.projectone.shared.projectone.model.location.CountryModel", "Projectone.projectone.shared.projectone.model.location.StateModel", "Projectone.projectone.shared.projectone.model.location.RegionModel", "Projectone.projectone.shared.projectone.model.location.DistrictModel", "Projectone.projectone.shared.projectone.viewmodel.location.TalukaViewModel", "Ext.form.field.CustomDateField"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Taluka",
               "name": "TalukaTreeContainer",
               "itemId": "TalukaTreeContainer",
               "restURL": "/Taluka",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "TalukaTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "836A4CE5-4104-4D3B-9E1E-1D6473960402",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Projectone.projectone.shared.projectone.model.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "CC6ECD6F-8988-440B-AAAF-3A84B690F1D2",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Projectone.projectone.shared.projectone.model.location.StateModel"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region",
                         "fieldId": "367589BD-7114-4420-93C2-2121F2B33415",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Projectone.projectone.shared.projectone.model.location.RegionModel"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District",
                         "fieldId": "91340DE7-77ED-4BEA-A465-9565A7ECB959",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Projectone.projectone.shared.projectone.model.location.DistrictModel"
                         }
                    }, {
                         "name": "talukaName",
                         "itemId": "talukaName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Name",
                         "fieldId": "60BD3296-FFC2-4F85-B9D6-5246F8D31085",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "talukaCode",
                         "itemId": "talukaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Code",
                         "fieldId": "ADCD1A6A-BBBD-4011-BDD0-42A2B7A4566E",
                         "minLength": "0",
                         "maxLength": "32"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "TalukaViewModel",
                    "xtype": "form",
                    "displayName": "Taluka",
                    "title": "Taluka",
                    "name": "Taluka",
                    "itemId": "Taluka",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "836A4CE5-4104-4D3B-9E1E-1D6473960402",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Projectone.projectone.shared.projectone.model.location.CountryModel"
                         },
                         "forceSelection": true,
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CC6ECD6F-8988-440B-AAAF-3A84B690F1D2",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Projectone.projectone.shared.projectone.model.location.StateModel"
                         },
                         "forceSelection": true,
                         "bind": "{stateId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onStateIdChange"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "367589BD-7114-4420-93C2-2121F2B33415",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Projectone.projectone.shared.projectone.model.location.RegionModel"
                         },
                         "forceSelection": true,
                         "bind": "{regionId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onRegionIdChange"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "91340DE7-77ED-4BEA-A465-9565A7ECB959",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Projectone.projectone.shared.projectone.model.location.DistrictModel"
                         },
                         "forceSelection": true,
                         "bind": "{districtId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaName",
                         "itemId": "talukaName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "60BD3296-FFC2-4F85-B9D6-5246F8D31085",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{talukaName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaCode",
                         "itemId": "talukaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "ADCD1A6A-BBBD-4011-BDD0-42A2B7A4566E",
                         "minLength": "0",
                         "maxLength": "32",
                         "bind": "{talukaCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaDescription",
                         "itemId": "talukaDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "taluka Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Description",
                         "fieldId": "F1801156-EAD6-4E62-950C-D4332E3A340D",
                         "bind": "{talukaDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaFlag",
                         "itemId": "talukaFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "E76BE1C3-D617-44F3-9843-699DC3B18573",
                         "minLength": "0",
                         "maxLength": "128",
                         "bind": "{talukaFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaLatitude",
                         "itemId": "talukaLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "talukaaLatitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "talukaaLatitude",
                         "fieldId": "B9EBE299-5733-4D0B-B974-DD913AB1BAFC",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{talukaLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaLongitude",
                         "itemId": "talukaLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Citry Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Citry Longitude",
                         "fieldId": "3C3C8041-9D3F-465A-94AE-0190887B4C02",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{talukaLongitude}",
                         "columnWidth": 0.5
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 295,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 295,
                              "customId": 539
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 295,
                              "customId": 540,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 295,
                              "customId": 541,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Taluka",
                    "title": "Details Grid",
                    "name": "TalukaGrid",
                    "itemId": "TalukaGrid",
                    "restURL": "/Taluka",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "taluka Id",
                         "dataIndex": "talukaId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region",
                         "dataIndex": "regionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "District",
                         "dataIndex": "districtId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "taluka Name",
                         "dataIndex": "talukaName",
                         "flex": 1
                    }, {
                         "header": "taluka Code",
                         "dataIndex": "talukaCode",
                         "flex": 1
                    }, {
                         "header": "taluka Description",
                         "dataIndex": "talukaDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "talukaFlag",
                         "flex": 1
                    }, {
                         "header": "talukaaLatitude",
                         "dataIndex": "talukaLatitude",
                         "flex": 1
                    }, {
                         "header": "Citry Longitude",
                         "dataIndex": "talukaLongitude",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "TalukaViewModel",
               "xtype": "form",
               "displayName": "Taluka",
               "title": "Taluka",
               "name": "Taluka",
               "itemId": "Taluka",
               "bodyPadding": 10,
               "items": [{
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "836A4CE5-4104-4D3B-9E1E-1D6473960402",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Projectone.projectone.shared.projectone.model.location.CountryModel"
                    },
                    "forceSelection": true,
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CC6ECD6F-8988-440B-AAAF-3A84B690F1D2",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Projectone.projectone.shared.projectone.model.location.StateModel"
                    },
                    "forceSelection": true,
                    "bind": "{stateId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onStateIdChange"
                    }
               }, {
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Region",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "367589BD-7114-4420-93C2-2121F2B33415",
                    "restURL": "Region",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Projectone.projectone.shared.projectone.model.location.RegionModel"
                    },
                    "forceSelection": true,
                    "bind": "{regionId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onRegionIdChange"
                    }
               }, {
                    "name": "districtId",
                    "itemId": "districtId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "District",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "91340DE7-77ED-4BEA-A465-9565A7ECB959",
                    "restURL": "District",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Projectone.projectone.shared.projectone.model.location.DistrictModel"
                    },
                    "forceSelection": true,
                    "bind": "{districtId}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaName",
                    "itemId": "talukaName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "60BD3296-FFC2-4F85-B9D6-5246F8D31085",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{talukaName}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaCode",
                    "itemId": "talukaCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "ADCD1A6A-BBBD-4011-BDD0-42A2B7A4566E",
                    "minLength": "0",
                    "maxLength": "32",
                    "bind": "{talukaCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaDescription",
                    "itemId": "talukaDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "taluka Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Description",
                    "fieldId": "F1801156-EAD6-4E62-950C-D4332E3A340D",
                    "bind": "{talukaDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaFlag",
                    "itemId": "talukaFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "E76BE1C3-D617-44F3-9843-699DC3B18573",
                    "minLength": "0",
                    "maxLength": "128",
                    "bind": "{talukaFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaLatitude",
                    "itemId": "talukaLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "talukaaLatitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "talukaaLatitude",
                    "fieldId": "B9EBE299-5733-4D0B-B974-DD913AB1BAFC",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{talukaLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaLongitude",
                    "itemId": "talukaLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Citry Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Citry Longitude",
                    "fieldId": "3C3C8041-9D3F-465A-94AE-0190887B4C02",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{talukaLongitude}",
                    "columnWidth": 0.5
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 295,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 295,
                         "customId": 539
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 295,
                         "customId": 540,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 295,
                         "customId": 541,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});