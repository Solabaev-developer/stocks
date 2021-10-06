Ext.define('ModernApp.Application', {
	extend: 'Ext.app.Application',
	name: 'ModernApp',

	launch: function () {
		console.log('Launch LearnJS APP');
	},

	mainView: 'ModernApp.view.main.MainView'
});
