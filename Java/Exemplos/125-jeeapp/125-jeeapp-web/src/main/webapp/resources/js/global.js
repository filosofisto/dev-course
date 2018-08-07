/**
 * Utilitarios globais
 */

window.onbeforeunload = function () {
	window.location.reload();
};

var Util = {};

Util.loadMask = function(){
	var maskBehavior = function (val) {
		return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		},
	options = {onKeyPress: function(val, e, field, options) {
		field.mask(maskBehavior.apply({}, arguments), options);
	}};

	$('.phone').mask(maskBehavior, options);

	var pesoMaskBehavior = function (val) {
		return val.replace(/\D/g, '').length === 5 ? '000,00' : '00,009';
	},
	pesoOptions = {onKeyPress: function(val, e, field, options) {
		field.mask(pesoMaskBehavior.apply({}, arguments), options);
	}};

	$('.peso').mask(pesoMaskBehavior, pesoOptions);
	
	var medidaMaskBehavior = function (val) {
		return val.replace(/\D/g, '').length === 4 ? '00,00' : '0,009';
	},
	medidaOptions = {onKeyPress: function(val, e, field, options) {
		field.mask(medidaMaskBehavior.apply({}, arguments), options);
	}};

	$('.medida').mask(medidaMaskBehavior, medidaOptions);
};

function showDialogOnSuccess(args, dialogWidgetVar) {
    if (args && !args.validationFailed) {
        PF(dialogWidgetVar).show();
    }
}

function hideDialogOnSuccess(args, dialogWidgetVar) {
    if (args && !args.validationFailed) {
        PF(dialogWidgetVar).hide();
    }
}