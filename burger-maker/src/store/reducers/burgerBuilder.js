import * as actionTypes from '../actions/actionTypes';


const INGREDIANT_PRICES={
    salad:20,
    cheese:30,
    meat:70,
    bacon:50,
}

const intialState={
    ingrediants:null,
    totalPrice:20,
    error:false
}

const reducer=(state=intialState,action)=>{
    switch(action.type)
    {
        case actionTypes.ADD_INGREDIANT:
            return {
                ...state,
                ingrediants:{
                    ...state.ingrediants,
                    [action.ingrediant]:state.ingrediants[action.ingrediant]+1
                },
                totalPrice:state.totalPrice+INGREDIANT_PRICES[action.ingrediant]
            };
        case actionTypes.REMOVE_INGREDIANT:
            return {
                ...state,
                ingrediants:{
                    ...state.ingrediants,
                    [action.ingrediant]:state.ingrediants[action.ingrediant]-1
                },
                totalPrice:state.totalPrice-INGREDIANT_PRICES[action.ingrediant]
            };

        case actionTypes.SET_INGREDIANTS:
            return{
                ...state,
                ingrediants:action.ingrediants,
                totalPrice:20,
                error:false
            }
        case actionTypes.FETCH_INGREDIANTS_FAILED:
            return {
                ...state,
                error:true
            }

        default : return state;
        
    }
}

export default reducer;