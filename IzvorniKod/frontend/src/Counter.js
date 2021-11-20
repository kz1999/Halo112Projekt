import React from 'react';

function Counter(){
    
    const [counter, setCounter] = React.useState(0);

    function reset(){
        setCounter(0);
    }

    function increment(){
        setCounter(oldCounter => oldCounter+1);
    }

    React.useEffect( ()=>{
        document.title= `you clicked ${counter} times`;
    },[counter]);

    return(
        <div>
            <span>{counter}</span>
            <button onClick={reset}>RESET</button>
            <button onClick={increment}>INCREMENT</button>
        </div>
    )
    

}

export default Counter;