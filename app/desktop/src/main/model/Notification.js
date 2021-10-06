Ext.define('ModernApp.view.model.Notification', {
    extend: 'Ext.data.Model',

    fields: [{
        name: 'date',
        type: 'date'
    }, {
        name: 'description',
        type: 'string'
    }]
});