package alpvax.minecraftforge.annotation;

import javax.lang.model.element.VariableElement;

public class StringAnnotatedConstant
{
	private VariableElement annotatedElement;
	private String value;

	public StringAnnotatedConstant(VariableElement element)
	{
		annotatedElement = element;
		CompiledConstantString annotation = element.getAnnotation(CompiledConstantString.class);
		value = annotation.value();
	}
}
