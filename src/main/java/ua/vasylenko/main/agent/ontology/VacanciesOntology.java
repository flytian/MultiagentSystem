package ua.vasylenko.main.agent.ontology;

import ua.vasylenko.main.agent.ontology.impl.*;


import java.util.Collection;

import org.protege.owl.codegeneration.CodeGenerationFactory;
import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.FactoryHelper;
import org.protege.owl.codegeneration.impl.ProtegeJavaMapping;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.protege.owl.codegeneration.inference.SimpleInference;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

/**
 * A class that serves as the entry point to the generated code providing access
 * to existing individuals in the ontology and the ability to create new individuals in the ontology.<p>
 * 
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: VacanciesOntology<br>
 * @version generated on Sat Oct 07 21:28:33 EEST 2017 by Тёма
 */
public class VacanciesOntology implements CodeGenerationFactory {
    private OWLOntology ontology;
    private ProtegeJavaMapping javaMapping = new ProtegeJavaMapping();
    private FactoryHelper delegate;
    private CodeGenerationInference inference;

    public VacanciesOntology(OWLOntology ontology) {
	    this(ontology, new SimpleInference(ontology));
    }
    
    public VacanciesOntology(OWLOntology ontology, CodeGenerationInference inference) {
        this.ontology = ontology;
        this.inference = inference;
        javaMapping.initialize(ontology, inference);
        delegate = new FactoryHelper(ontology, inference);
    }

    public OWLOntology getOwlOntology() {
        return ontology;
    }
    
    public void saveOwlOntology() throws OWLOntologyStorageException {
        ontology.getOWLOntologyManager().saveOntology(ontology);
    }
    
    public void flushOwlReasoner() {
        delegate.flushOwlReasoner();
    }
    
    public boolean canAs(WrappedIndividual resource, Class<? extends WrappedIndividual> javaInterface) {
    	return javaMapping.canAs(resource, javaInterface);
    }
    
    public  <X extends WrappedIndividual> X as(WrappedIndividual resource, Class<? extends X> javaInterface) {
    	return javaMapping.as(resource, javaInterface);
    }
    
    public Class<?> getJavaInterfaceFromOwlClass(OWLClass cls) {
        return javaMapping.getJavaInterfaceFromOwlClass(cls);
    }
    
    public OWLClass getOwlClassFromJavaInterface(Class<?> javaInterface) {
	    return javaMapping.getOwlClassFromJavaInterface(javaInterface);
    }
    
    public CodeGenerationInference getInference() {
        return inference;
    }

    /* ***************************************************
     * Class http://www.semanticweb.org/тёма/ontologies/2017/9/untitled-ontology-11#Link
     */

    {
        javaMapping.add("http://www.semanticweb.org/тёма/ontologies/2017/9/untitled-ontology-11#Link", Link.class, DefaultLink.class);
    }

    /**
     * Creates an instance of type Link.  Modifies the underlying ontology.
     */
    public Link createLink(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_LINK, DefaultLink.class);
    }

    /**
     * Gets an instance of type Link with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Link getLink(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_LINK, DefaultLink.class);
    }

    /**
     * Gets all instances of Link from the ontology.
     */
    public Collection<? extends Link> getAllLinkInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LINK, DefaultLink.class);
    }


}