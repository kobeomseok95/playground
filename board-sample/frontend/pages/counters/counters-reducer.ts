export type Action =
    | { type: 'increment' }
    | { type: 'decrement' }
    | { type: 'reset' }

const CountersReducer = (state: number, action: Action): number => {
    switch (action.type) {
        case "increment":
            return state + 1
        case "decrement":
            return state - 1
        case "reset":
            return 0
        default:
            throw new Error()
    }
}

export default CountersReducer
