/*******************************************************************************
 * Copyright (c) 2010, 2013 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Stuart McCulloch (Sonatype, Inc.) - initial API and implementation
 *******************************************************************************/
package org.eclipse.sisu.inject;

import com.google.inject.Binding;
import com.google.inject.ImplementedBy;
import com.google.inject.Injector;

/**
 * Mutable {@link BeanLocator} that finds and tracks bindings across zero or more {@link BindingPublisher}s.
 */
@ImplementedBy( DefaultBeanLocator.class )
public interface MutableBeanLocator
    extends BeanLocator
{
    /**
     * Adds the given ranked {@link BindingPublisher} and distributes its {@link Binding}s.
     * 
     * @param publisher The new publisher
     * @param rank The assigned rank
     */
    void add( BindingPublisher publisher, int rank );

    /**
     * Removes the given {@link BindingPublisher} and its {@link Binding}s.
     * 
     * @param publisher The old publisher
     */
    void remove( BindingPublisher publisher );

    /**
     * Removes all known {@link BindingPublisher}s and their {@link Binding}s.
     */
    void clear();

    /**
     * Adds the given ranked {@link Injector} and distributes its {@link Binding}s. Marked as deprecated because most
     * clients should <b>not</b> call this method; any injector that contains a binding to the {@link BeanLocator} is
     * automatically added to that locator as part of the bootstrapping process.
     * 
     * @param injector The new injector
     * @param rank The assigned rank
     */
    @Deprecated
    void add( Injector injector, int rank );

    /**
     * Removes the given {@link Injector} and its {@link Binding}s.
     * 
     * @param injector The old injector
     */
    @Deprecated
    void remove( Injector injector );
}