///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            P1 Part2
// Files:            Sym.java
// Semester:         Spring 2020
//
// Author:           Li Yinjie
// Email:            li2324@wisc.edu
// CS Login:         li2324
// Lecturer's Name:  Loris D'Antoni
//////////////////////////// 80 columns wide //////////////////////////////////


/**
 * Represents a symbol in a programe
 * Each symbol has its own type
 *
 * Bugs: none known
 *
 * @author       Li Yinjie
 * @version      1.0
 */
class Sym
{
    /**This symbol's type, stored as a string */
    public String type;

    /**
     * Construct a sym, whose type is the same as the input "String type" 
     *
     * @param type The type for this new sym
     */
    public Sym(String type)
    {
        this.type=type;
    }

    /**
     * Return the type of this sym 
     *
     *@return the type of the sym
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Translate the information of the sym into a string and return it 
     * to be modified in the future for more information stored
     *
     * @return a String that contains the information of the sym.
     */
    public String toString()
    {
        return this.type;
    }
} // end of Sym class