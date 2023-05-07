/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
     let presentCount = init
    return {
        increment:()=> ++presentCount,
        decrement:()=> --presentCount,
        reset:()=> presentCount = init,
    }
};

