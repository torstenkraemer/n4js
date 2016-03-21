(function(System) {
	'use strict';
	System.register([], function($n4Export) {
		var async, IFIXME, FIXME1, IFIXME2, FIXME2;
		async = function async(cb, reject) {
			return function() {
				var $capturedArgs = arguments;
				try {
					cb.apply(null, $capturedArgs);
				} catch(ex) {
					try {
						reject.call({}, ex);
					} catch(ex3) {
						console.log(ex3);
					}
				}
			};
		};
		$n4Export('async', async);
		IFIXME = {};
		$n4Export('IFIXME', IFIXME);
		FIXME1 = function FIXME1() {
			IFIXME.$fieldInit(this, undefined, {
				logStr: undefined
			});
		};
		$n4Export('FIXME1', FIXME1);
		IFIXME2 = {};
		$n4Export('IFIXME2', IFIXME2);
		FIXME2 = function FIXME2() {
			IFIXME2.$fieldInit(this, undefined, {
				logStr: undefined
			});
		};
		$n4Export('FIXME2', FIXME2);
		return {
			setters: [],
			execute: function() {
				IFIXME.$fieldInit = function IFIXME_fieldInit(target, spec, mixinExclusion) {};
				IFIXME.$methods = {};
				$makeInterface(IFIXME, function(instanceProto, staticProto) {
					var metaClass = new N4Interface({
						name: 'IFIXME',
						origin: 'eu.numberfour.mangelhaft',
						fqn: 'n4.mangel.Test.IFIXME',
						n4superType: undefined,
						allImplementedInterfaces: [],
						ownedMembers: [
							new N4Accessor({
								name: 'logStr',
								getter: true,
								isStatic: false,
								annotations: []
							})
						],
						consumedMembers: [],
						annotations: []
					});
					return metaClass;
				});
				$makeClass(FIXME1, Object, [
					IFIXME
				], {
					logStr: {
						get: function getLogStr___n4() {
							return "FIXME joe from Mangelhaft";
						}
					}
				}, {}, function(instanceProto, staticProto) {
					var metaClass = new N4Class({
						name: 'FIXME1',
						origin: 'eu.numberfour.mangelhaft',
						fqn: 'n4.mangel.Test.FIXME1',
						n4superType: N4Object.n4type,
						allImplementedInterfaces: [
							'n4.mangel.Test.IFIXME'
						],
						ownedMembers: [
							new N4Accessor({
								name: 'logStr',
								getter: true,
								isStatic: false,
								annotations: []
							})
						],
						consumedMembers: [],
						annotations: []
					});
					return metaClass;
				});
				IFIXME2.$fieldInit = function IFIXME2_fieldInit(target, spec, mixinExclusion) {
					if (spec) {
						if (!(mixinExclusion.hasOwnProperty('party') || target.hasOwnProperty('party'))) {
							target.party = 'party' in spec ? spec.party : false;
						}
					} else {
						if (!(mixinExclusion.hasOwnProperty('party') || target.hasOwnProperty('party'))) {
							target.party = false;
						}
					}
				};
				IFIXME2.$methods = {};
				$makeInterface(IFIXME2, function(instanceProto, staticProto) {
					var metaClass = new N4Interface({
						name: 'IFIXME2',
						origin: 'eu.numberfour.mangelhaft',
						fqn: 'n4.mangel.Test.IFIXME2',
						n4superType: undefined,
						allImplementedInterfaces: [],
						ownedMembers: [
							new N4DataField({
								name: 'party',
								isStatic: false,
								annotations: []
							}),
							new N4Accessor({
								name: 'logStr',
								getter: true,
								isStatic: false,
								annotations: []
							})
						],
						consumedMembers: [],
						annotations: []
					});
					return metaClass;
				});
				$makeClass(FIXME2, Object, [
					IFIXME2
				], {
					logStr: {
						get: function getLogStr___n4() {
							return "FIXME joe from Mangelhaft";
						}
					},
					party: {
						value: undefined,
						writable: true
					}
				}, {}, function(instanceProto, staticProto) {
					var metaClass = new N4Class({
						name: 'FIXME2',
						origin: 'eu.numberfour.mangelhaft',
						fqn: 'n4.mangel.Test.FIXME2',
						n4superType: N4Object.n4type,
						allImplementedInterfaces: [
							'n4.mangel.Test.IFIXME2'
						],
						ownedMembers: [
							new N4Accessor({
								name: 'logStr',
								getter: true,
								isStatic: false,
								annotations: []
							})
						],
						consumedMembers: [
							new N4DataField({
								name: 'party',
								isStatic: false,
								annotations: []
							})
						],
						annotations: []
					});
					return metaClass;
				});
			}
		};
	});
})(typeof module !== 'undefined' && module.exports ? require('n4js-node/index').System(require, module) : System);
//# sourceMappingURL=Test.map