package com.spring.Spring.di;

public class DependencyInjection {
	private Inner inner;
	public DependencyInjection(Inner inner)
	{
		this.inner=inner;
	}
	
	public void show()
	{
		System.out.println("DependencyInjection");
		inner.show();
	}

}
