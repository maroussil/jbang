package dev.jbang.cli;

import java.io.PrintWriter;

import dev.jbang.Settings;

import picocli.CommandLine;

@CommandLine.Command(name = "version", description = "Display version info.")
public class Version extends BaseCommand {

	@Override
	public Integer doCall() {
		PrintWriter out = spec.commandLine().getOut();

		out.println(dev.jbang.BuildConfig.VERSION);

		if (isVerbose()) {
			out.println("Cache: " + Settings.getCacheDir());
			out.println("Config: " + Settings.getConfigDir());
			out.println("Repository:" + Settings.getLocalMavenRepo());
		}
		return CommandLine.ExitCode.OK;
	}
}
