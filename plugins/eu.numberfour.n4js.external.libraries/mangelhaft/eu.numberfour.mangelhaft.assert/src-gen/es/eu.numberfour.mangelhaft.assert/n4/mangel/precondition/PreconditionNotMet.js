(function(System) {
	'use strict';
	System.register([], function($n4Export) {
		var PreconditionNotMet;
		PreconditionNotMet = function PreconditionNotMet(message) {
			var err = new Error(message);
			this.message = err.message;
			this.name = this.constructor.n4type.name;
			Object.defineProperty(this, 'stack', { get: function() { return err.stack; }, set: function(value) { err.stack = value; } });
			this.name = "PreconditionNotMet";
		};
		$n4Export('PreconditionNotMet', PreconditionNotMet);
		return {
			setters: [],
			execute: function() {
				$makeClass(PreconditionNotMet, Error, [], {
					name: {
						value: undefined,
						writable: true
					}
				}, {}, function(instanceProto, staticProto) {
					var metaClass = new N4Class({
						name: 'PreconditionNotMet',
						origin: 'eu.numberfour.mangelhaft.assert',
						fqn: 'n4.mangel.precondition.PreconditionNotMet.PreconditionNotMet',
						n4superType: undefined,
						allImplementedInterfaces: [],
						ownedMembers: [
							new N4DataField({
								name: 'name',
								isStatic: false,
								annotations: []
							})
						],
						consumedMembers: [],
						annotations: []
					});
					return metaClass;
				});
			}
		};
	});
})(typeof module !== 'undefined' && module.exports ? require('n4js-node/index').System(require, module) : System);
//# sourceMappingURL=PreconditionNotMet.map
