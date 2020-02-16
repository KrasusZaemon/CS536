///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            P1 Part2
// Files:            SymTable.java
// Semester:         Spring 2020
//
// Author:           Li Yinjie
// Email:            li2324@wisc.edu
// CS Login:         li2324
// Lecturer's Name:  Loris D'Antoni
//////////////////////////// 80 columns wide //////////////////////////////////


import java.util.*;     /** needed for using HashMap to store syms,
                            and LinkedList to store the HashMaps     */


/**
 * This class ia a table to store sym from programs.
 * There is a list to hold many HashMaps,
 * Each HashMap represent a scope in the program.
 * HashMap holds the the information for the syms in corresponding scope.
 * The HashMap is mapped basing on the name for each sym.
 *
 * Bugs: none known
 *
 * @author       Li Yinjie
 * @version      1.0
 * @see also     Sym, EmptySymTableException, DuplicateSymException
 */
class SymTable
{
    
    /** The LinkedList to hold the HashMap for syms in different scope */
    private LinkedList<HashMap<String,Sym>> H_table;

    /** The constructor, just create the LinkedList and add one HashMap in */
    public SymTable()
    {
        this.H_table = new LinkedList<HashMap<String,Sym>>();
        HashMap<String,Sym> newh = new HashMap<String,Sym>(); //temporarily
                                                              //hold the
                                                              //HashMap until
                                                              //added to table
        this.H_table.addFirst(newh);
    }

    /**
     * Adds a sym whose name is name to the corresponding HashMap by its name
     * Now the sym is directly added to the first HashMap in the LinkedList
     * Throws EmptySymTableException if the LinkedList is empty.
     * Throws DuplicateSymException if the name of the sym already exists.
     *
     * @param name The name of the sym
       @param sym The Structure Sym which contains the information of the sym
     */
    public void addDecl(String name, Sym sym)throws DuplicateSymException,
                                                    EmptySymTableException
    {
        if(this.H_table.isEmpty())
        {
            throw new EmptySymTableException();
        }
        if(name==null || sym==null)
        {
            throw new IllegalArgumentException();
        }
        if(this.H_table.getFirst().containsKey(name))
        {
            throw new DuplicateSymException();
        }

        this.H_table.getFirst().put(name,sym);
    }

    /**
     * Adds a new HashMap to the front of the LinkedList,
     * which means a new scope.
     */
    public void addScope()
    {
        HashMap<String,Sym> newh = new HashMap<String,Sym>(); //temporarily
                                                              //hold the
                                                              //HashMap until
                                                              //added to table
        this.H_table.addFirst(newh);
    }

    /**
     * Look for the sym by its name in the first HashMap,
     * which means the current scope. And return the sym if found,
     * else: return null. 
     * Throws an EmptySymTableException if the LinkedList is empty
     *
     * @param name The name of the sym that is to look up.
     * @return the Sym with the corresponding name, if found any,
     * else return null.
     */
    public Sym lookupLocal(String name) throws EmptySymTableException
    {
        if(this.H_table.isEmpty())
        {
            throw new EmptySymTableException();
        }
        if(this.H_table.getFirst().containsKey(name))
        {
            return this.H_table.getFirst().get(name);
        }

        return null;
    }

    /**
     * Look for the sym by its name in the all the HashMaps,
     * which means all the scopes. And return the sym if found,
     * else: return null. 
     * Throws an EmptySymTableException if the LinkedList is empty.
     *
     * @param name The name of the sym that is to look up.
     * @return the Sym with the corresponding name, if found any,
     * else return null.
     */
    public Sym lookupGlobal(String name) throws EmptySymTableException
    {
        if(this.H_table.isEmpty())
        {
            throw new EmptySymTableException();
        }

        Iterator itr = this.H_table.iterator();
        while(itr.hasNext())
        {
            @SuppressWarnings("unchecked")
            HashMap<String,Sym> it=(HashMap<String,Sym>) itr.next(); //hold the
                                                                     //current
                                                                     //HashMap
                                                                     //until
                                                                     //used up
            if(it.containsKey(name))
            {
                return it.get(name);
            }
        }
        return null;
    }

    /**
     * Remove the first HashMap in the LinkedList,
     * which means removing the current scope.
     * Throws an EmptySymTableException if the LinkedList is empty.
     */
    public void removeScope() throws EmptySymTableException
    {
        if(this.H_table.isEmpty())
        {
            throw new EmptySymTableException();
        }
        this.H_table.removeFirst();
    }

    /**
     * Print the information of the whole table
     * by printing out all the HashMaps.
     */
    public void print()
    {
        System.out.print("\nSym Table\n");
        Iterator<HashMap<String,Sym>> iter = this.H_table.listIterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
        System.out.println("");
    }
} // end of SymTable class