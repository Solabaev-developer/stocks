Ext.define('ModernApp.view.main.MainView', {
    extend: 'Ext.tab.Panel',

    requires: [
        'Ext.Button',
        'Ext.field.Text'
    ],

    controller: 'main',
    viewModel: {
        data: {
            userName: ''
        }
    },

    items: [{
        title: 'Home',
        html: '<h1 class="main-banner">Hello World!</h1>',
        items: [{
            xtype: 'button',
            handler: 'onGo',
            bind: {
                disabled: '{!userName}',
                text: '{userName ? "Save: " + userName : "Save"}'
            }
        }, {
            xtype: 'textfield',
            label: 'User name',
            bind: '{userName}',
            listeners: {
                action: 'onGo'
            }
        }]
    }, {
        title: 'Notifications',
        xtype: 'notifications'
    }, {
        title: 'Settings'
    }]
});