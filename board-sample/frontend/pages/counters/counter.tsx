import React, { useReducer } from 'react'
import CountersReducer, {Action} from "./counters-reducer";

export const Counter = () => {
    const [state, dispatch] = useReducer(CountersReducer, 0)

    const onIncrease = () => {
        dispatch({ type: 'increment' })
    }

    const onDecrease = () => {
        dispatch({ type: 'decrement' })
    }

    const onReset = () => {
        dispatch({ type: 'reset' })
    }

    return (
        <div>
            <h1>{state}</h1>
            <button onClick={onIncrease}> + 1 </button>
            <button onClick={onDecrease}> - 1 </button>
            <button onClick={onReset}> reset </button>
        </div>
    )
}

export default Counter
