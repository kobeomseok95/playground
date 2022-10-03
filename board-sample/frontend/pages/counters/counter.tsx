import React, { useState } from 'react'

export const Counter = () => {
    // todo useReducer 방식으로 전환해보기
    const [number, setNumber] = useState(0)
    const onIncrease = () => {
        setNumber(number + 1)
    }
    const onDecrease = () => {
        setNumber(number - 1)
    }
    return (
        <div>
            <h1>{number}</h1>
            <button onClick={onIncrease}> + 1 </button>
            <button onClick={onDecrease}> - 1 </button>
        </div>
    )
}

export default Counter
