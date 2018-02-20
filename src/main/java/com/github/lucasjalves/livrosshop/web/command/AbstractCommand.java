package com.github.lucasjalves.livrosshop.web.command;


import com.github.lucasjalves.livrosshop.core.facade.impl.FacadeImpl;

public abstract class AbstractCommand implements Command{
	protected FacadeImpl facade = FacadeImpl.getInstance();
}
