n4.$define('NFARProject-0.0.1/NFARClass',['require', 'exports', 'module'], function(require, exports, module){
var NFARClass = function NFARClass() {}
    $makeClass(	NFARClass, Object,
        {
            privateMethod: { value: function 
             privateMethod(){}}
        },
        {},
        function(instanceProto, staticProto){
        	var metaClass = new N4Class({
        		name: 'NFARClass',
        		origin: 'NFARProject-0.0.1',
        		fqn: 'NFARClass.NFARClass',
        		n4superType: N4Object.n4type,
        		allImplementedInterfaces: [],
        		annotations : [],
        		ownedMembers : [new N4Method({name : 'privateMethod', jsFunction: instanceProto['privateMethod'],annotations : []}),],
        		consumedMembers : []
        	});
        metaClass.annotations.forEach(function(a){
        	Object.defineProperty(a, 'target', {value: metaClass, enumerable:false});
        });
        if(typeof metaClass.ownedMembers !== 'undefined'){
        	metaClass.ownedMembers.forEach(function(m){
        		Object.defineProperty(m, 'owner', {value: metaClass, enumerable:false});
        		if(typeof m.annotations !== 'undefined'){
        			m.annotations.forEach(function(a){
        				Object.defineProperty(a, 'target', {value: m, enumerable:false});
        			})
        		}
        	});
        }
        return metaClass;
        }
        );


module.exports = {
};
});