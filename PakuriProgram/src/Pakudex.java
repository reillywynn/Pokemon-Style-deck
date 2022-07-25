public class Pakudex {
    private int pakudexCapacity = 0;
    private Pakuri [] pakudex;

    public Pakudex() {
        pakudex = new Pakuri [20];
    }

    public Pakudex(int capacity) {
       pakudex = new Pakuri [capacity];

       for (int i = 0; i < getCapacity(); i++) {
           pakudex[i] = null;
       }
    }

    public int getSize() {
        return this.pakudexCapacity;
    }

    public int getCapacity() {
        return pakudex.length;
    }

    public String[] getSpeciesArray() {
        if(pakudexCapacity <= 0) {
            return null;
        }

        String[] speciesArray = new String [pakudexCapacity];

        for (int i = 0; i < pakudexCapacity; i ++) {
            if (pakudex[i] != null) {
                speciesArray[i] = pakudex[i].getSpecies();
            }
        }
        return speciesArray;

    }

    public int[] getStats(String species) {
        int [] stats = null;
        Pakuri requiredPakuri = null;

        String [] speciesArray = getSpeciesArray();
        if (speciesArray == null) {
            return null;
        }

        for (int i = 0; i < pakudexCapacity; i++) {
            if (pakudex[i] != null) {
                String pakuriSpecies = pakudex[i].getSpecies();
                if (pakuriSpecies.contentEquals(species)) {
                    requiredPakuri = pakudex[i];
                }
            }
        }

        if(requiredPakuri == null) {
            return null;
        }

        for(int i = 0; i < pakudexCapacity; i++)
        {
            if(speciesArray[i] != null)
            {
                if (speciesArray[i].contentEquals(species))
                {
                    int A = requiredPakuri.getAttack();
                    int D = requiredPakuri.getDefense();
                    int S = requiredPakuri.getSpeed();
                    stats = new int[]{A, D, S};
                }
            }
        }

        return stats;
    }

    public void sortPakuri()
    {
//Compares the first Pakuri with the next in a series, switches if necessary
        for(int i = 0; i < pakudexCapacity - 1; i++)
        {
            for(int j = i + 1; j < pakudexCapacity; j++)
            {
                if(pakudex[i] != null && pakudex[j] != null)
                {
                    String firstSpecies = pakudex[i].getSpecies();
                    String nextSpecies = pakudex[j].getSpecies();
                    if (firstSpecies.compareTo(nextSpecies) > 0)
                    {
                        Pakuri placeHolder = pakudex[j];
                        pakudex[j] = pakudex[i];
                        pakudex[i] = placeHolder;
                    }
                }
            }
        }
    }

    public boolean addPakuri(String species)
    {
//Exception if pakudex is full handled in PakuriProgram because its checked before method is applied
//Exception if the species already exists
        for(int i = 0; i < pakudexCapacity; i++)
        {
            if(pakudex[i] != null)
            {
                String exists = pakudex[i].getSpecies();

                if(exists.contentEquals(species))
                {
                    return false;
                }
            }
        }

//If no exceptions, add species
        pakudex[pakudexCapacity] = new Pakuri(species);
        pakudexCapacity = pakudexCapacity + 1;
        return true;
    }

    public boolean evolveSpecies(String species)
    {
//Initialize
        Pakuri requiredPakuri = null;

//Exception if there are no Pakuri in Pakudex
        if(pakudexCapacity <= 0)
        {
            return false;
        }

//Obtain required Pakuri
        for(int i = 0; i < pakudexCapacity; i++)
        {
            if(pakudex[i] != null)
            {
                String exists = pakudex[i].getSpecies();
                if(exists.contentEquals(species))
                {
                    requiredPakuri = pakudex[i];
                }

            }
        }

//Exception if the Pakuri doesn't exist
        if(requiredPakuri == null)
        {
            return false;
        }

        requiredPakuri.evolve();
        return true;

    }

}





