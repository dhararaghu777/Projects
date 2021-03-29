import * as actionTypes from './actionTypes';
import axios from '../../axios-orders';

export const add_ingrediant = (name)=>{
    return {
        type:actionTypes.ADD_INGREDIANT,
        ingrediant:name
    }
}

export const remove_ingrediant = (name)=>{
    return {
        type:actionTypes.REMOVE_INGREDIANT,
        ingrediant:name
    }
}


export const setIngrediants=(ingrediants)=>{
    return {
        type:actionTypes.SET_INGREDIANTS,
        ingrediants:ingrediants
    }
}

export const fetchIngrediantsFailed=()=>{
    return {
        type:actionTypes.FETCH_INGREDIANTS_FAILED
    }
}

export const initIngrediants=()=>{
    return dispatch=>{
        axios.get("https://burger-maker-208f3-default-rtdb.firebaseio.com/ingrediants.json")
        .then(response=>{
            dispatch(setIngrediants(response.data));
        }).catch(error=>{
            dispatch(fetchIngrediantsFailed());
        })
    }
}