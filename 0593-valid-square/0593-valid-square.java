class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        int[][] points = { p1, p2, p3, p4 };

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                set.add(squareDistance(points[i], points[j]));
            }
        }
        return !set.contains(0) && set.size() == 2;
    }

    private int squareDistance(int[] a, int[] b) {
        int xDiff = a[0] - b[0];
        int yDiff = a[1] - b[1];
        return xDiff * xDiff + yDiff * yDiff;
    }
}