package com.ikubinfo.internship.project.utils;

public interface ConverterInterface<P, E> {

	public E fromPojoToEntity(P pojo);

	public P fromEntityToPojo(E entity);

}
