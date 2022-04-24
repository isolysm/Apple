# Why?
Since we aren't using the [Essential Gradle Toolkit](https://github.com/EssentialGG/essential-gradle-toolkit), we're going to need to implement our own version ourselves, which
this is the only way we're going to even do that. (That repository is licensed under the GPL.)
We also cannot artifact at the moment, so we're forced to locally apply this because this is the only way we'll be able to do anything.

Another thing to note is that Fabric and Quilt both use different looms, making Essential's loom completely redundant in that case, so that's adding more insult to injury

This also means that some versions of this Toolkit will be modified from Essential's. We will give them credit where credit is due.

Also they do not currently support Quilt, so this is why this was made.

# Plugins
* [Replaymod's Preprocessor](https://github.com/ReplayMod/preprocessor)
