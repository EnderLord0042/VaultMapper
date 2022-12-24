package com.enderlord.vaultmapper.shapes;

public enum VaultShapes {
     DIAMOND1(new boolean[][]{
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
             {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
             {false, false, false, false, false, true , true , true , true , true , true , true , false, false, false, false, false},
             {false, false, false, false, false, false, true , true , true , true , true , false, false, false, false, false, false},
             {false, false, false, false, false, false, false, true , true , true , false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, true , false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
             {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
     });
    public boolean[][] predictedSpots;
    VaultShapes(boolean[][] booleans) {
        predictedSpots = booleans;
    }
}
