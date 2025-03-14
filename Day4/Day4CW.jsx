import React from 'react'
import { TextField,Autocomplete,Button, selectClasses } from '@mui/material'
 const fruit=["Apple","Mango","PineApple","WaterMelon","Grapes","Jack","Strawberry"]

 class Fruits extends React.Component{
    constructor(props)
    {
        super(props);
       this.state={
         name:'',
         selectFruit:null,
         message:''
        }
    }
    handleChange=(e)=>
    {
        this.setState({
            name:e.target.value
        })
    }
    handleSelect=(_,newvalue)=>{
        this.setState({
         selectFruit:newvalue
        })
    }
    handleSubmit=(e)=>{
        e.preventDefault();
        const{name,selectFruit}=this.state;
        if(name&&selectFruit)
        {
            this.setState({
                message:`Hello ${name}!.. Yours favourite fruit is ${selectFruit}`
            })
        }
    }
    render()
    {
        const { name,selectFruit,message}=this.state;
        return(
            <div style={{background:"aqua"}}>
                <center>
            <form onSubmit={this.handleSubmit}>
           <TextField
           label="Name"
           value={name}
           onChange={this.handleChange}
           data-testid="name">

           </TextField>
           <Autocomplete
           options={fruit}
           value={selectFruit}
           onChange={this.handleSelect}
           renderInput={(params)=>(
            <TextField {...params}
            label="choose a fruit"
            data-testid="autocomplete"/>
           )}
           data-testid="autocomplete">
            
           </Autocomplete>
           <Button type="submit" variant='contained' color='primary'>Submit</Button>
           {message && <h1>{message}</h1>}
           </form>
           </center>
           </div>

          
        )
    }
 }
 export default Fruits