package org.jboss.gradle.plugins.jdocbook;

import java.io.File;

import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.TaskAction;

/**
 * Task to apply GNU <a href="http://www.gnu.org/software/gettext/">gettext</a>-based translations to generate
 * translated DocBook sources from the master language source and the translation PO files (see
 * <a href="http://en.wikipedia.org/wiki/GNU_gettext">http://en.wikipedia.org/wiki/GNU_gettext</a> for discussion).
 *
 * @author Steve Ebersole
 */
@SuppressWarnings({ "UnusedDeclaration" })
public class TranslateTask extends AbstractTranslationTask {
	private static final Logger log = Logging.getLogger( TranslateTask.class );

	@InputDirectory
	public File getMasterSourceDirectory() {
		return getPlugin().getDirectoryLayout().getMasterSourceDirectory();
	}

	@TaskAction
	public void translate() {
		log.lifecycle( "translating {} into {}", getTranslationLanguage(), getTranslationOutputDirectory() );
		getPlugin().getComponentRegistry().getTranslator().translate( getTranslationSource() );
	}
}