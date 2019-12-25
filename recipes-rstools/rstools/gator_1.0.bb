DESCRIPTION = "ARM DS5 Gator Debugger"
AUTHOR = "Jim Rucker <jrucker@altera.com>"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://README.md;md5=fd73f0498116d3d0c987310ab2def003"
S="${WORKDIR}/git"
BP="${BPN}"
DEPENDS = "virtual/kernel"
inherit module

SRC_URI = "git://git.linaro.org/git-ro/arm/ds5/gator.git;protocol=http"
SRCREV="7ca6004c0b05138c49b9b21e0045487f55a60ab6"
INHIBIT_PACKAGE_STRIP="1"

INSANE_SKIP_${PN}-dev += " ldflags"
INSANE_SKIP_${PN} += " ldflags"

do_compile() {
	echo "Using Custom compile step"
	cd ${S}/driver
	${MAKE} -C ${STAGING_KERNEL_DIR} M=`pwd` ARCH=${TARGET_ARCH} CROSS_COMPILE=${TARGET_PREFIX} modules
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
	cd ${S}/daemon
	${MAKE} -j5 ARCH="arm" CROSS_COMPILE=${TARGET_PREFIX}
}

do_install() {

	INIT_DIR=${D}${sysconfdir}/init.d/
	install -d ${INIT_DIR}
	install -m 0644 ${S}/driver/gator.ko ${INIT_DIR}
        install -m 0755 ${S}/daemon/gatord ${INIT_DIR}/gatord
	echo -e "#!/bin/bash\n/etc/init.d/gatord & 2>/dev/null" > ${INIT_DIR}/rungator.sh
	chmod a+x ${INIT_DIR}/rungator.sh
}

FILES_${PN} = "${sysconfdir}/init.d/gator.ko ${sysconfdir}/init.d/gatord ${sysconfdir}/init.d/rungator.sh"
