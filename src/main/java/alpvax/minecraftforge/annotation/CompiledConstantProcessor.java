package alpvax.minecraftforge.annotation;

import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;

import com.google.auto.service.AutoService;

@AutoService(Processor.class)
public class CompiledConstantProcessor extends AbstractProcessor
{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
	{
		for(VariableElement field : ElementFilter.fieldsIn(roundEnv.getElementsAnnotatedWith(CompiledConstantString.class)))
		{
			TypeMirror fieldType = field.asType();
			String fullTypeClassName = fieldType.toString();
			if (!String.class.getName().equals(fullTypeClassName))
			{
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Element must be a field with type java.lang.String", field);
				return true;
			}
			if(!field.getModifiers().containsAll(EnumSet.of(Modifier.STATIC, Modifier.FINAL)))
			{
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Element must be a static final field", field);
			}
			field.
		}
		return true;
	}
	//private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<String, FactoryGroupedClasses>();

	@Override
	public Set<String> getSupportedAnnotationTypes()
	{
		Set<String> annotataions = new LinkedHashSet<String>();
		annotataions.add(CompiledConstantString.class.getCanonicalName());
		return annotataions;
	}
}
