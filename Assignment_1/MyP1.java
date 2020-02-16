
///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            P1 PartA
// Files:            Sym.java, SymTable.java, DuplicateSymException.java, EmptySymTableException.java
// Semester:         Spring 2020
//
// Author:           Li Yinjie
// Email:            li2324@wisc.edu
// CS Login:         li2324
// Lecturer's Name:  Loris D'Antoni
//

public class P1{
    public static void main(String[] args) {

        String Type_int = "int";


        //Testing the Sym class

        //Testing the Sym constructor
        try {
            Sym Testing_Sym = new Sym("Type_int");
        }catch (Exception e){
            System.out.println("Sym constructor failed for Exception:"+e);
        }

        //Testing the Sym getType()
        Sym Testing_Sym = new Sym(Type_int);

        //runtime
        try {
            String Type = Testing_Sym.getType();
        }catch (Exception e){
            System.out.println("Sym getType() failed for Exception:"+e);
        }

        //correctness
        String Type = Testing_Sym.getType();
        if(!Type.equals(Type_int)){
            System.out.println("Sym getType() failed, shoud be:"+Type_int+",while the output is"+Type);
        }


        //Testing the Sym toString()

        //runtime
        try {
            Type = Testing_Sym.toString();
        }catch (Exception e){
            System.out.println("Sym toString() failed for Exception:"+e);
        }

        //correctness
        Type = Testing_Sym.toString();
        if(!Type.equals(Type_int)){
            System.out.println("Sym toString() failed, shoud be:"+Type_int+",while the output is"+Type);
        }







        //Testing the SymTable class

        //Testing the SymTable constructor
        try{
            SymTable Testing_SymTable = new SymTable();
        }catch(Exception e){
            System.out.println("SymTable constructor failed for Exception:"+e);
        }


        //Testing the SymTable addDecl(String name, Sym sym)

        //Testing Empty table
        try{
            SymTable Testing_SymTable_addDecl = new SymTable();
            Testing_SymTable_addDecl.removeScope();
            Testing_SymTable_addDecl.addDecl("addDecl",Testing_Sym);
            System.out.println("SymTable addDecl() failed for No Throw when table is Empty");
        }catch(EmptySymTableException e){

        }catch(Exception e){
            System.out.println("SymTable addDecl() failed for throw a wrong Exception:"+e+" when table is Empty");
        }

        //Testing when name is null
        try{
            SymTable Testing_SymTable_addDecl = new SymTable();
            Testing_SymTable_addDecl.addDecl(null,Testing_Sym);
            System.out.println("SymTable addDecl() failed for No Throw when name is null");
        }catch(IllegalArgumentException e){

        }catch(Exception e){
            System.out.println("SymTable addDecl() failed for throw a wrong Exception:"+e+" when name is null");
        }

        //Testing when sym is null
        try{
            SymTable Testing_SymTable_addDecl = new SymTable();
            Testing_SymTable_addDecl.addDecl("addDecl",null);
            System.out.println("SymTable addDecl() failed for No Throw when sym is null");
        }catch(IllegalArgumentException e){

        }catch(Exception e){
            System.out.println("SymTable addDecl() failed for throw a wrong Exception:"+e+" when sym is null");
        }

        //Testing when sym and name are both null
        try{
            SymTable Testing_SymTable_addDecl = new SymTable();
            Testing_SymTable_addDecl.addDecl(null,null);
            System.out.println("SymTable addDecl() failed for No Throw when sym and name are both null");
        }catch(IllegalArgumentException e){

        }catch(Exception e){
            System.out.println("SymTable addDecl() failed for throw a wrong Exception:"+e+" when sym and name are both null");
        }

        //Testing when name is already occupied
        try{
            SymTable Testing_SymTable_addDecl = new SymTable();
            Testing_SymTable_addDecl.addDecl("addDecl",Testing_Sym);
            Testing_SymTable_addDecl.addDecl("addDecl",Testing_Sym);
            System.out.println("SymTable addDecl() failed for No Throw when adding twice with the same name");
        }catch(DuplicateSymException e){

        }catch(Exception e){
            System.out.println("SymTable addDecl() failed for throw a wrong Exception:"+e+" adding twice with the same name");
        }

        //Testing whether Adding successfully
        try{
            SymTable Testing_SymTable_addDecl = new SymTable();
            Testing_SymTable_addDecl.addDecl("addDecl",Testing_Sym);
            Sym Recive = Testing_SymTable_addDecl.lookupLocal("addDecl");
            if(Recive==null){
                System.out.println("SymTable addDecl() failed for fail for adding");
            }
        }catch(Exception e){
            System.out.println("SymTable addDecl() failed for throw a wrong Exception:"+e+" when checking adding successfully");
        }



        //Testing the SymTable addScope()

        //Testing runtime error
        try{
            SymTable Testing_SymTable_addScope = new SymTable();
            Testing_SymTable_addScope.addScope();
        }catch(Exception e){
            System.out.println("SymTable addScope() failed for Exception:"+e);
        }

        //Testing adding successfully
        try{
            SymTable Testing_SymTable_addScope = new SymTable();
            Testing_SymTable_addScope.addDecl("addDecl",Testing_Sym);
            Testing_SymTable_addScope.addScope();
            Sym Recive = Testing_SymTable_addScope.lookupLocal("addDecl");
            if(Recive != null){
                System.out.println("SymTable addScope() failed fail in Adding");
            }
        }catch(Exception e){
            System.out.println("SymTable addScope() failed for Exception:"+e);
        }

        //Testing lookupLocal(String name)

        //Testing runtime error
        try{
            SymTable Testing_SymTable_lookupLocal = new SymTable();
            Testing_SymTable_lookupLocal.addDecl("addDecl",Testing_Sym);
            Sym Recive = Testing_SymTable_lookupLocal.lookupLocal("addDecl");
        }catch(Exception e){
            System.out.println("SymTable lookupLocal() failed for Exception:"+e);
        }

        //Testing Empty table
        try{
            SymTable Testing_SymTable_lookupLocal = new SymTable();
            Testing_SymTable_lookupLocal.removeScope();
            Sym Recive = Testing_SymTable_lookupLocal.lookupLocal("addDecl");
        }catch(EmptySymTableException e){
        //expected
        }catch(Exception e){
            System.out.println("SymTable lookupLocal() failed for throw a wrong Exception:"+e+" when lookupLocal() empty table");
        }

        //Testing Correctness
        //Exist
        try{
            SymTable Testing_SymTable_lookupLocal = new SymTable();
            Testing_SymTable_lookupLocal.addDecl("addDecl",Testing_Sym);
            Sym Recive = Testing_SymTable_lookupLocal.lookupLocal("addDecl");
            if(Recive == null){
                System.out.println("SymTable lookupLocal() failed for return null when key exists");
            }
        }catch(Exception e){
            System.out.println("SymTable lookupLocal() failed for Exception:"+e);
        }

        //Not Exist
        try{
            SymTable Testing_SymTable_lookupLocal = new SymTable();
            Testing_SymTable_lookupLocal.addDecl("addDecl",Testing_Sym);
            Sym Recive = Testing_SymTable_lookupLocal.lookupLocal("Decl");
            if(Recive != null){
                System.out.println("SymTable lookupLocal() failed for doesn't return null when key doesn't exist");
            }
        }catch(Exception e){
            System.out.println("SymTable lookupLocal() failed for Exception:"+e);
        }



        //Testing lookupGlobal(String name)

        //Testing runtime error
        try{
            SymTable Testing_SymTable_lookupGlobal = new SymTable();
            Testing_SymTable_lookupGlobal.addDecl("addDecl",Testing_Sym);
            Sym Recive = Testing_SymTable_lookupGlobal.lookupGlobal("addDecl");
        }catch(Exception e){
            System.out.println("SymTable lookupGlobal() failed for Exception:"+e);
        }

        //Testing Empty table
        try{
            SymTable Testing_SymTable_lookupGlobal = new SymTable();
            Testing_SymTable_lookupGlobal.removeScope();
            Sym Recive = Testing_SymTable_lookupGlobal.lookupGlobal("addDecl");
        }catch(EmptySymTableException e){
        //expected
        }catch(Exception e){
            System.out.println("SymTable lookupGlobal() failed for throw a wrong Exception:"+e+" when lookupGlobal() empty table");
        }

        //Testing Correctness
        //Exist
        try{
            SymTable Testing_SymTable_lookupGlobal = new SymTable();
            Testing_SymTable_lookupGlobal.addDecl("addDecl",Testing_Sym);
            Sym Recive = Testing_SymTable_lookupGlobal.lookupGlobal("addDecl");
            if(Recive == null){
                System.out.println("SymTable lookupGlobal() failed for return null when key exists");
            }
        }catch(Exception e){
            System.out.println("SymTable lookupGlobal() failed for Exception:"+e);
        }

        //Not in first Hash
        try{
            SymTable Testing_SymTable_lookupGlobal = new SymTable();
            Testing_SymTable_lookupGlobal.addDecl("addDecl",Testing_Sym);
            Testing_SymTable_lookupGlobal.addScope();
            Sym Recive = Testing_SymTable_lookupGlobal.lookupGlobal("addDecl");
            if(Recive == null){
                System.out.println("SymTable lookupGlobal() failed for return null when key exists");
            }
        }catch(Exception e){
            System.out.println("SymTable lookupGlobal() failed for Exception:"+e);
        }

        //Not Exist
        try{
            SymTable Testing_SymTable_lookupGlobal = new SymTable();
            Testing_SymTable_lookupGlobal.addDecl("addDecl",Testing_Sym);
            Sym Recive = Testing_SymTable_lookupGlobal.lookupGlobal("Decl");
            if(Recive != null){
                System.out.println("SymTable lookupGlobal() failed for doesn't return null when key doesn't exist");
            }
        }catch(Exception e){
            System.out.println("SymTable lookupGlobal() failed for Exception:"+e);
        }






        //Testing the SymTable removeScope()

        //Testing runtime error
        try{
            SymTable Testing_SymTable_remove = new SymTable();
            Testing_SymTable_remove.removeScope();
        
        //Empty table when initial
        }catch(EmptySymTableException e){
            System.out.println("SymTable constructor failed for Empty table");
        }catch(Exception e){
            System.out.println("SymTable removeScope() failed for Exception:"+e);
        }

        //Testing empty table
        try{
            SymTable Testing_SymTable_remove = new SymTable();
            Testing_SymTable_remove.removeScope();
            try{
                Testing_SymTable_remove.removeScope();
                System.out.println("SymTable removeScope() failed for no Exception when table empty");
            }catch(EmptySymTableException e){
            //expected
            }catch(Exception e){
                System.out.println("SymTable removeScope() failed for Exception but not EmptySymTableException");
            }
        }catch(Exception e){
            System.out.println("SymTable removeScope() failed for Exception:"+e);
        }

        //Testing removing successfully
        try{
            SymTable Testing_SymTable_remove = new SymTable();
            Testing_SymTable_remove.addScope();
            Testing_SymTable_remove.addDecl("addDecl",Testing_Sym);
            Testing_SymTable_remove.removeScope();
            Sym Recive = Testing_SymTable_remove.lookupGlobal("addDecl");
            if(Recive != null){
                System.out.println("SymTable removeScope() failed for removing not successfully");
            }
        }catch(Exception e){
            System.out.println("SymTable removeScope() failed for Exception:"+e);
        }



        //Testing print()
        try{
            SymTable Testing_SymTable_print = new SymTable();
            Testing_SymTable_print.addDecl("addDecl",Testing_Sym);
            Testing_SymTable_print.print();
        }catch(Exception e){
            System.out.println("SymTable print() failed for Exception:"+e);
        }
    }
}