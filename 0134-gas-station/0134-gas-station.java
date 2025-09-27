class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startStation = 0;
        int n = gas.length; // Correct way to get array length

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            
            currentTank += gas[i] - cost[i];

            // If current tank ever drops below 0, it means we cannot reach station i+1
            // from the current startStation. So, we reset the tank and try the next station
            // as a potential starting point.
            if (currentTank < 0) {
                currentTank = 0;
                startStation = i + 1;
            }
        }

        // If total gas is less than total cost, it's impossible to complete the circuit.
        // Otherwise, a unique solution exists, and startStation holds that solution.
        if (totalGas < totalCost) {
            return -1;
        } else {
            return startStation;
        }
    }
}