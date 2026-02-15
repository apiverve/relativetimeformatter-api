from setuptools import setup, find_packages

setup(
    name='apiverve_relativetimeformatter',
    version='1.1.13',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Relative Time Formatter is a tool for converting timestamps and dates to human-readable relative time formats like '2 hours ago' or 'in 3 days'. It supports multiple styles and custom reference times for flexible time representation.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/relativetimeformatter?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
