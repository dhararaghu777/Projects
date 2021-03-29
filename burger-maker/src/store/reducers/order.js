import * as actionTypes from '../actions/actionTypes';

const initState={
    order:[],
    loading:false,
    purchased:false
}

const reducer=(state=initState,action)=>{
    
    switch(action.type){

        case actionTypes.PURCHASE_INIT:
            return {
                ...state,
                purchased:false
            }
        
        case actionTypes.PURCHASE_BURGER_START:
            return {
                ...state,
                loading:true
            }
            
        case actionTypes.PURCHASE_BURGER_SUCCESS:
            const newOrder={
                ...action.orderData,
                id:action.id
            }
            return {
                ...state,
                loading:false,
                purchased:true,
                order:state.order.concat(newOrder)
            };

        case actionTypes.PURCHASE_BURGER_FAILED:
            return {
                ...state,
                loading:false
            };

        case actionTypes.FETCH_ORDERS_START:
            return {
                ...state,
                loading:true
            }
        case actionTypes.FETCH_ORDERS_SUCCESS:
            return {
                ...state,
                loading:false,
                order:action.orders
            }
        case actionTypes.FETCH_ORDERS_FAIL:
            return {
                ...state,
                loading:false
            }
            
        default :
            return state;
        
    }
}

export default reducer;