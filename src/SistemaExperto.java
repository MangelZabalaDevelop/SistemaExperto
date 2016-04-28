

import Rule.*;


/**
 *
 * @author Mangel
 */

/*Prueba de ejecucion  */
public class SistemaExperto {
    
    /* Creamos el Objeto  */
    BooleanRuleBase basedereglas = new BooleanRuleBase("basedereglas");
    
    RuleVariable mujer;
    RuleVariable mayor18;
    RuleVariable ResultadoMujer;
    RuleVariable ResultadoMayor18;
    
    String resultado="";
    
    public String obtenerGenero(String mujer,String mayor18)
    {
        BaseConocimiento();
        this.mujer.setValue(mujer);
        this.mayor18.setValue(mayor18);
        basedereglas.forwardChain();
        
        resultado=ResultadoMujer.getValue();
           
        return resultado;
    }
    public String obtenerEdad(String mujer,String mayor18)
    {
        BaseConocimiento();
        this.mujer.setValue(mujer);
        this.mayor18.setValue(mayor18);
        basedereglas.forwardChain();
        
        resultado=ResultadoMayor18.getValue();
           
        return resultado;
    }
    
    public void BaseConocimiento()
    {
    
         mujer = new RuleVariable(basedereglas,"");
         mayor18= new RuleVariable(basedereglas,"");;
         ResultadoMujer= new RuleVariable(basedereglas,"");;
         ResultadoMayor18= new RuleVariable(basedereglas,"");;
    
    Condition igual = new Condition("=");
    
    Rule primeraRegla = new Rule(basedereglas,"primeraRegla",
    new Clause[]
    {
        new Clause(mujer,igual,"si"),
        new Clause(mayor18,igual,"no")},
         new Clause (ResultadoMujer,igual,"Es una Niña")
    
    );
    Rule segundaRegla = new Rule(basedereglas,"segundaRegla",
    new Clause[]
    {
        new Clause(mujer,igual,"si"),
        new Clause(mayor18,igual,"si")},
         new Clause (ResultadoMujer,igual,"es una mujer")
    
    );
    Rule terceraRegla = new Rule(basedereglas,"terceraRegla",
    new Clause[]
    {
        new Clause(mujer,igual,"no"),
        new Clause(mayor18,igual,"no")},
         new Clause (ResultadoMujer,igual,"Es un niño")
    
    );
    Rule cuartaRegla = new Rule(basedereglas,"cuartaRegla",
    new Clause[]
    {
        new Clause(mujer,igual,"no"),
        new Clause(mayor18,igual,"si")},
         new Clause (ResultadoMujer,igual,"es un hombre")
    
    );
    }
    
   
    
}
