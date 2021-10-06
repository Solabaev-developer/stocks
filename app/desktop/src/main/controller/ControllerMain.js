Ext.define('MyApp.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main',

    requires: [
        'Ext.MessageBox'
    ],

    onGo: function (userName) {
        Ext.Msg.alert('Go', 'From main view controller');
    }
});