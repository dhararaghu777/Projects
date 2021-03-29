import React from 'react';
import {connect} from 'react-redux';
import classes from './ContactData.module.css';
import axios from '../../../axios-orders';
import Button from '../../../components/UI/Button/Button';
import Spinner from '../../../components/UI/Spinner/Spinner';
import Input from '../../../components/UI/Input/input';

import withErrorHandler from '../../../hoc/withErrorHandler/withErrorHandler';
import * as actions from '../../../store/actions/index';

class ContactData extends React.Component{
    state={
        orderForm:{
           name :{
               elementType:'input',
               elementConfig:{
                   type:'text',
                   placeholder:'Your Name'
               },
               value:'',
               validation:{
                   required:true
               },
               valid:false,
               touched:false
           },

            street :{
                elementType:'input',
                elementConfig:{
                    type:'text',
                    placeholder:'Your Street'
                },
                value:'',
                validation:{
                    required:true
                },
                valid:false,
                touched:false
            },
            zipCode :{
                elementType:'input',
                elementConfig:{
                    type:'text',
                    placeholder:'ZIP'
                },
                value:'',
                validation:{
                    required:true,
                    minLen:6,
                    maxLen:6
                },
                valid:false,
                touched:false
            },
            country :{
                elementType:'input',
                elementConfig:{
                    type:'text',
                    placeholder:'Country'
                },
                value:'',
                validation:{
                    required:true
                },
                valid:false,
                touched:false
            }, 
            email:{
                elementType:'input',
                elementConfig:{
                    type:'email',
                    placeholder:'Your E-Mail'
                },
                value:'',
                validation:{
                    required:true
                },
                valid:false,
                touched:false
            },
            
            deliveryMethod:{
                elementType:'select',
                elementConfig:{
                    options:[
                        {value:'fastest', displayValue:'Fastest'},
                        {value:'cheapest', displayValue:'Cheapest'},
                    ]
                },
                value:'fastest',
                validation:{
                    required:false
                },
                valid:true
            },
        },
        formIsValid:false,


    }

    checkValidity(value,rules){
        let isValid=true;
        if(rules.required)
        {
            isValid=value.trim()!=='' && isValid;
        }
        if(rules.minLen){
            isValid=value.length>=rules.minLen && isValid;
        }
        if(rules.maxLen){
            isValid=value.length<=rules.maxLen && isValid;
        }

        return isValid;
    }

    inputChangeHandler=(event,inputIndentifier)=>{
        const updatedOrderForm={...this.state.orderForm};
        const updatedFormElement={...updatedOrderForm[inputIndentifier]};

        updatedFormElement.value=event.target.value;
        updatedFormElement.valid=this.checkValidity(updatedFormElement.value,updatedFormElement.validation);
        updatedFormElement.touched=true;
        updatedOrderForm[inputIndentifier]=updatedFormElement;

        let formIsValid=true;
        for(let input in updatedOrderForm){
            formIsValid=updatedOrderForm[input].valid && formIsValid;
        }
        
        this.setState({orderForm:updatedOrderForm,formIsValid:formIsValid}); 
    }

    orderHandler=(event)=>{
        event.preventDefault();
        
        let formData={};
        for(let formElementIdentifier in this.state.orderForm)
        {
            formData[formElementIdentifier]=this.state.orderForm[formElementIdentifier].value;
        }

            const order={
                ingrediants:this.props.ings,
                price:this.props.price,
                orderData:formData
            }
        
            this.props.onOrderBurger(order);
            
    }

    render(){

        const formElementsArray=[];
        for(let key in this.state.orderForm)
        {
            formElementsArray.push({
                id:key,
                config:this.state.orderForm[key]
            })
        }

        let form=(
            <form onSubmit={this.orderHandler}>
                {
                    formElementsArray.map(formElement=>(
                        <Input key={formElement.id}
                               elementType={formElement.config.elementType}
                               elementConfig={formElement.config.elementConfig}
                               value={formElement.config.value}
                               invalid={!formElement.config.valid}
                               shouldValidate={formElement.config.validation}
                               touched={formElement.config.touched}
                               changed={(event)=>this.inputChangeHandler(event,formElement.id)} />
                    ))
                }
                <Button btnType="Success" 
                        disabled={!this.state.formIsValid}>ORDER</Button>
            </form>
        )
        if(this.props.loading)
        {
            form=<Spinner />
        }

        return (
            <div className={classes.ContactData}>
                <h4>Enter your Contact Data</h4>
                {form}
            </div>
        )
    }
}


const mapStateToProps=state=>{
    return {
        ings:state.burgerBuilder.ingrediants,
        price:state.burgerBuilder.totalPrice,
        loading:state.order.loading
    }
}

const mapDispatchToProps=(dispatch)=>{
    return {
        onOrderBurger:(order)=>dispatch(actions.purchaseBurger(order))
    }
}




export default connect(mapStateToProps,mapDispatchToProps)(withErrorHandler(ContactData,axios));