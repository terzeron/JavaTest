package net.terzeron.pattern.command;

public interface Command {
	public void execute();
	public void undo();
}
