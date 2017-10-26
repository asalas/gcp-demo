package com.cirrocode.support;

/**
 *
 * @author asalas
 * 
 * @param <SOURCE>
 * @param <TARGET>
 */
public abstract class ObjectConverter<SOURCE, TARGET>
{
    SOURCE source;
    TARGET target;
    
    protected abstract TARGET convert(SOURCE source);
}