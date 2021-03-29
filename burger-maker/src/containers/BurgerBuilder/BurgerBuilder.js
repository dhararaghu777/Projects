import React,{Component} from 'react';
import {connect} from 'react-redux';
import Auxilary from '../../hoc/Auxilary/Auxilary';
import Burger from '../../components/Burger/Burger';
import BuildControls from '../../components/Burger/BuildControls/BuildControls';
import Modal from '../../components/UI/Modal/Modal';
import OrderSummary from '../../components/Burger/OrderSummary/OrderSummary';
import axios from '../../axios-orders';
import Spinner from '../../components/UI/Spinner/Spinner';
import withErrorHandler from '../../hoc/withErrorHandler/withErrorHandler';
import * as actions from '../../store/actions/index';
import Button from '../../components/UI/Button/Button';


class BurgerBuilder extends Component{

        state={
            purchasing:false,
        
        }

        componentDidMount(){
        //    console.log(this.props)
           this.props.onInitIngrediants();
        }


        updatePurchaseState(ingrediant){
           
            const sum=Object.values(ingrediant)
                            .reduce((sum,el)=>{
                                return sum+el
                            },0);
            return sum>0;
        }

        purchaseHandler=()=>{
            this.setState({purchasing:true});
        }

        purchaseCancelHandler=()=>{
            this.setState({purchasing:false})
        }

        purchaseContinueHandler=()=>{
            this.props.onInitPurchase();
            this.props.history.push('/checkout');
        }

        render(){

            const disabledInfo={...this.props.ings};

            for(let key in disabledInfo)
            {
                disabledInfo[key]=disabledInfo[key]<=0;
            }

            let orderSummary=null;
        
            let burger= this.props.error ?<p>Ingredients can't be loaded</p> :<Spinner />

            if(this.props.ings)
            {
                burger=(
                    <Auxilary>
                        <Burger ingrediants={this.props.ings} />
                        <BuildControls 
                        ingrediantAdded={this.props.onIngrediantAdded}
                        ingrediantRemoved={this.props.onIngrediantRemoved} 
                        disabled={disabledInfo} 
                        purchaseable={this.updatePurchaseState(this.props.ings)}
                        ordered={this.purchaseHandler} 
                        price={this.props.price} />
                    </Auxilary>);

                orderSummary=(<OrderSummary 
                ingrediants={this.props.ings}
                price={this.props.price}
                purchaseCancelled={this.purchaseCancelHandler}
                purchaseContinued={this.purchaseContinueHandler} 
                />);
            }

           
            return(
                <Auxilary>
                    <Modal show={this.state.purchasing} modalClosed={this.purchaseCancelHandler} >
                        {orderSummary}
                    </Modal>
                    {burger}
                </Auxilary>
            )
        }
}

const mapStateToProps=(state)=>{
    return {
        ings:state.burgerBuilder.ingrediants,
        price:state.burgerBuilder.totalPrice,
        error:state.burgerBuilder.error
    }
}


const mapDispatchToProps=(dispatch)=>{
    return{
        onIngrediantAdded:(ingName)=>dispatch(actions.add_ingrediant(ingName)),

        onIngrediantRemoved:(ingName)=>dispatch(actions.remove_ingrediant(ingName)),

        onInitIngrediants: ()=>dispatch(actions.initIngrediants()),
        onInitPurchase:()=>dispatch(actions.purchaseInit())
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(withErrorHandler(BurgerBuilder,axios));




